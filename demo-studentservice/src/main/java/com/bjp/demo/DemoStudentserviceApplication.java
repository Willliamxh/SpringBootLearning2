package com.bjp.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.bjp.demo.dao")
public class DemoStudentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStudentserviceApplication.class, args);
	}

}
