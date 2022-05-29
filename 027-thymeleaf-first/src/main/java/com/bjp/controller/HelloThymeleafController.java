package com.bjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Willam_xh
 * @Date 2022-05-28 15:50
 */
@Controller
public class HelloThymeleafController {
    @GetMapping("/hello")
    public String helloThymeleaf(HttpServletRequest request){
        request.setAttribute("data","欢迎使用thymeleaf");

        //指定视图（模板引用使用的页面（html））
        //逻辑名称  classpath:/templates/hello.html
        return "hello";
    }
}
