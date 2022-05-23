package com.bjp.service.impl;

import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @Author Willam_xh
 * @Date 2022-05-19 11:19
 */


/**
 * 使用dubbo中的注解暴露服务
 */
// @Component //注入到容器中

/**
 * Component可以不用加
 * interfaceClass也可以不用加
 */
@DubboService(interfaceClass = StudentService.class,version = "1.0",timeout = 15000)
public class StudentServiceImpl implements StudentService {

    @Override
    public Student queryStudent(Integer id) {
        Student student  = new Student();
        if( 1001 == id){
            student.setId(1001);
            student.setName("====1001-张三");
            student.setAge(20);
        } else if(1002  == id){
            student.setId(1002);
            student.setName("#*****1002-李四");
            student.setAge(22);
        }

        return student;
    }
}
