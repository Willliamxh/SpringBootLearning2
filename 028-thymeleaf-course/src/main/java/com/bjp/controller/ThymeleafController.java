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


    //循环数组
    @GetMapping("/eachArray")
    public String eachArray(Model model){
        SysUser userarray[] = new SysUser[3];
        userarray[0] = new SysUser(1001,"马超","男",20);
        userarray[1] = new SysUser(1002,"黄忠","男",26);
        userarray[2] = new SysUser(1003,"赵云","男",22);
        model.addAttribute("userarray",userarray);

        return "eachArray";
    }

    //循环Map
    @GetMapping("/eachMap")
    public String eachMap(Model model){
        Map<String,SysUser> map = new HashMap<>();
        map.put("user1",new SysUser(11001,"马超","男",20));
        map.put("user2",new SysUser(11002,"黄忠","男",26));
        map.put("user3",new SysUser(11003,"赵云","男",22));
        model.addAttribute("mymap",map);


        Map<String,String>  strMap  = new HashMap<>();
        strMap.put("str1","Hello SpringBoot");
        strMap.put("str2","MyBatis MySQL");
        model.addAttribute("strmap",strMap);

        //复杂的List<Map>
        List<Map<String,SysUser>> listmap  =  new ArrayList<>();
        listmap.add(map);

        Map<String,SysUser> map1 = new HashMap<>();
        map1.put("sanguo1",new SysUser(21001,"典韦","男",22));
        map1.put("sanguo2",new SysUser(21002,"夏侯惇","男",28));
        map1.put("sanguo3",new SysUser(21003,"关胜","男",16));
        listmap.add(map1);

        model.addAttribute("listmap",listmap);


        return "eachMap";
    }


    // ifunless
    @GetMapping("/ifunless")
    public String ifunless(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("isLogin",true);
        model.addAttribute("age",20);
        model.addAttribute("name","");
        model.addAttribute("isOld",null);
        return "ifunless";

    }

    //switch
    @GetMapping("/switch")
    public String doSwitch(Model model){
        model.addAttribute("sex","m");
        return "switch";

    }

    // 内联 text
    @GetMapping("/inline")
    public String inline(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("age",20);
        model.addAttribute("name","张三");
        model.addAttribute("myuser" ,new SysUser(1005,"周峰","男",20));

        return "inline";

    }














}


