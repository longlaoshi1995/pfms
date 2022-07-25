package com.pfms.shiro;

import com.pfms.entity.User;
import com.pfms.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class ShiroRealm extends AuthenticatingRealm {
    @Autowired
    IUserService userService;

    /**
    *身份认证
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        //校验
        User user = userService.findByname(username);
        if(user == null) {
            throw new UnknownAccountException("用户名或密码有误！");
        }
        /**
         * principals: 可以使用户名，或d登录用户的对象
         * hashedCredentials: 从数据库中获取的密码
         * credentialsSalt：密码加密的盐值
         * RealmName:  类名（ShiroRealm）
         */
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), null, getName());
        return info; //框架完成验证
    }

    /**
     * 角色和授权
     * */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String yourInputUsername = (String) principals.getPrimaryPrincipal();
        //构造一个授权凭证
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //通过你的用户名查询数据库，得到你的权限信息与角色信息。并存放到权限凭证中
        info.addRole(getYourRoleByUsernameFromDB(yourInputUsername));
        info.addStringPermissions(getYourPermissionByUsernameFromDB(yourInputUsername));
        //返回你的权限信息
        return info;
    }

    private String getYourRoleByUsernameFromDB(String username) {
        return "coder";
    }

    private List<String> getYourPermissionByUsernameFromDB(String username) {
        return Arrays.asList("code：insert", "code：update");
    }

}
