package com.pfms.controller;
import com.pfms.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @PostMapping("/login")
    public String login(User user){
//使用 shiro 登录验证
        //1 认证的核心组件：获取 Subject 对象
        Subject subject = SecurityUtils.getSubject();
        //2 将登陆表单封装成 token 对象
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            //3 让 shiro 框架进行登录验证：
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            return "login/loginError";
        }
        return "index";
        }

}
