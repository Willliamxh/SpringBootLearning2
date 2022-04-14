package com.bjp;

import com.bjp.config.SpringConfig;
import com.bjp.vo.Cat;
import com.bjp.vo.Student;
import com.bjp.vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {



    /**
     * 使用xml作为容器的配置文件
     */
    @Test
    public void test1() {
        String config = "beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("容器中的对象：" + myStudent);

    }

    @Test
    public void tes02() {
        //形参类型：Class<?>... componentClasses 也就是说要有个组建类（java对象）的class类
        //那SpringConfig这个类里面有java对象 就是那个bean
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("createStudent");
        System.out.println("使用JavaConfig创建的bean对象：" + student);
    }

    @Test
    public void test03(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Student lisi= (Student) ctx.getBean("lisiStudent");
        System.out.println("使用JavaConfig创建的bean对象：" + lisi);


    }

    @Test
    public void test04(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat myCat= (Cat) ctx.getBean("myCat");
        System.out.println("使用ImportResource加载的猫：" + myCat);


    }

    @Test
    public void test05(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger myTiger= (Tiger) ctx.getBean("tiger");
        System.out.println("使用ImportResource加载的猫：" + myTiger);


    }



    /**
     * 许晗自己添加的测试
     */
    @Test
    public void test01(){
        String config="beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中的名称："+beanDefinitionName+"||"+ctx.getBean(beanDefinitionName));
        }
    }

    @Test
    public void test02(){

        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中的名称："+beanDefinitionName+"||"+ctx.getBean(beanDefinitionName));
        }
    }



}
