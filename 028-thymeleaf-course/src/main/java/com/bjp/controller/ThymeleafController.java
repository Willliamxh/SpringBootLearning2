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

    //链接表达式
    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("userId",1002);
        return "link";
    }

    //测试链接表达式的地址
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id){
        return "queryAccount,参数id="+id;
    }


    //有两个参数的地址
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name, Integer age){
        return "queryUser,有两个参数：name="+name+",age="+age;
    }

    //使用模板的属性
    @GetMapping("/property")
    public String useProperty(Model model){
        model.addAttribute("methodAttr","post");
        model.addAttribute("id","2342");

        model.addAttribute("paramname","name");
        model.addAttribute("uservalue","lisi");

        model.addAttribute("textcolor","color:blue");

        return "html-property";
    }

    //循环List
    @GetMapping("/eachList")
    public String eachList(Model model){
        List<SysUser> users  = new ArrayList<>();
        users.add( new SysUser(1001,"张三","m",20));
        users.add( new SysUser(1002,"关羽","m",70));
        users.add( new SysUser(1003,"张飞","m",60));
        users.add( new SysUser(1004,"刘备","m",80));
        users.add( new SysUser(1005,"孙尚香","f",50));
        model.addAttribute("myusers",users);
        return "eachList";
    }













}


