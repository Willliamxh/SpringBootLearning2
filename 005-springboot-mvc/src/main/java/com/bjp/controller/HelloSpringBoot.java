package com.bjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringBoot {
    @RequestMapping("/hello")
    @ResponseBody
    //@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
    // 写入到response对象的body区，
    // 通常用来返回JSON数据或者是XML数据.
    // 在使用此注解之后不会再走视图处理器，而
    // 是直接将数据写入到输入流中，
    // 他的效果等同于通过response对象输出指定格式的数据。
    public String helloSpringBoot(){
        return "欢迎使用springboot框架";
    }
}
