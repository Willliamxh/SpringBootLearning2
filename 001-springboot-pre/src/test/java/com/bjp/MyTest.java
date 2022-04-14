package com.bjp;

import com.bjp.vo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    /**
     * 使用xml作为容器的配置文件
     */
    @Test
    public void test(){
        String config="beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("容器中的对象："+myStudent);



    }

}
