package com.bjp;

import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);
		//获取容器对象
		ConfigurableApplicationContext ctx=SpringApplication.run(Application.class, args);
		// 从容器中获取对象
		StudentService userService=(StudentService) ctx.getBean("StudentServiceImpl");
		Student student = userService.queryStudent(1);
		System.out.println(student);

	}

}
