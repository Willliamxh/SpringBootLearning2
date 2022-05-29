package com.bjp.controller;

import com.bjp.model.SysUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    //第一个标准变量表达式
    @GetMapping("/expression1")
    public String expression1(Model model){
        //添加数据到Model
        model.addAttribute("site","www.bjpowernode.com");
        model.addAttribute("myuser", new SysUser(1001,"李四","m",20));

        //指定视图
        return "expression1";
    }

    //选择标准变量表达式
    @GetMapping("/expression2")
    public String expression2(Model model){
        //添加数据到Model
        model.addAttribute("site","www.bjpowernode.com");
        model.addAttribute("myuser", new SysUser(1001,"李四","m",20));
        //指定视图
        return "expression2";
    }

    // //链接表达式
    // @GetMapping("/link")
    // public String link(Model model){
    //     model.addAttribute("userId",1002);
    //     return "link";
    // }







}


