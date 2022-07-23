package com.pfms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;


@Controller
@RequestMapping(value = "/user")
public class LoginController {


    @RequestMapping("/login")
 //   @ResponseBody  (使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中)
    public String hello(){
        return "/login/test";
    }

    //登录成功后的返回地址
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "登录成功";
    }




}
