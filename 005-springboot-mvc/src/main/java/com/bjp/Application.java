package com.bjp;

import com.bjp.vo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //这个复合注解里面有 configuration，
    // 说明可以声明对象。对象能注入到容器
    @Bean
    public Student getStudent(){
        return new Student();
    }
}
