package com.bjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String helloThymeleaf(Model model, HttpServletRequest request){
        //添加数据到request作用域， 模板引擎可以从request中获取数据
        request.setAttribute("data","欢迎使用thymeleaf");

        //也可以使用model来存放对象
        model.addAttribute("mydata","model也可以用来存放数据");


        //指定视图（模板引用使用的页面（html））
        //逻辑名称  classpath:/templates/hello.html
        return "hello";
    }
}
