package com.bjp;

import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.bjp.dao")
public class Application {

    public static void main(String[] args) {
        //获取容器对象
        ConfigurableApplicationContext ctx=SpringApplication.run(Application.class, args);
        // 从容器中获取对象
        // String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        // for (String beanDefinitionName : beanDefinitionNames) {
        //     System.out.println("容器中的名称："+beanDefinitionName+"||"+ctx.getBean(beanDefinitionName));
        // }
        StudentService userService=(StudentService) ctx.getBean("studentServiceImpl");
        Student student = userService.queryStudent(2);
        System.out.println(student);
    }

}
