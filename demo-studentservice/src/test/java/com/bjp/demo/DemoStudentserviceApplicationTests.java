package com.bjp.demo;

import com.bjp.demo.dao.StudentDao;
import com.bjp.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoStudentserviceApplicationTests {

	@Resource
	private StudentDao studentDao;

	@Test
	public void test1(){
		Student student = studentDao.selectByPhone("123");
		System.out.println(student);
	}


	@Test
	void contextLoads() {

	}

}
