package com.bjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController {

    @RequestMapping("/hello")
    @ResponseBody
    public String soSome(){
        return "hello SpringBoot 应用";
    }

}
