package com.pfms.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//表示当前类是配置类
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  String[]  roles = new String[]{"bill","plan"};

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()  //分配权限
                .antMatchers("/login/**").permitAll()
                .antMatchers("/bill/**").hasRole(roles[0])
                .antMatchers("/plan/**").hasRole(roles[1]);

        http.formLogin();
   /*     http.formLogin()    //自定义登录页面
                .loginPage("/login.html")    //登录页面设置
                .loginProcessingUrl("/user/login")   //点击登录后访问的路径
                .defaultSuccessUrl("/index").permitAll()   //登录成功后跳转路径,permitAll表示无条件进行访问
                .and().authorizeRequests()
                .mvcMatchers("/","/hello","/user/login").permitAll() //设置不需要认证可以直接访问的路径
                .anyRequest().authenticated();
*/
        http.csrf().disable();//关闭csrf保护
    }


    //认证
    //账号和密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("longjun").password(new BCryptPasswordEncoder().encode("123456")).roles(roles[0],roles[1])
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles(roles[0],roles[1]);
    }

}
