package com.bjp;

import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @MapperScan: 找到Dao接口和Mapper文件
 *     basePackages：Dao接口所在的包名
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.bjp.dao",""})
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);
		//获取容器对象
		ConfigurableApplicationContext ctx=SpringApplication.run(Application.class, args);
		// 从容器中获取对象
		StudentService userService=(StudentService) ctx.getBean("StudentServiceImpl");
		Student student = userService.queryStudent(2);
		System.out.println(student);

	}

}
