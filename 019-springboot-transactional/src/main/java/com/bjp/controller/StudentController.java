package com.bjp.controller;

import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService service;

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(String name,Integer age){
        Student student = new Student();
        student.setAge(age);
        student.setName(name);

        int rows= service.addStudent(student);

        return "添加学生"+rows;
    }
}
