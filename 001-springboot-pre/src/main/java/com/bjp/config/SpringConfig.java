package com.bjp.config;

import com.bjp.vo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration:表示当前类是作为配置文件使用的。 就是用来配置容器的
 *       位置：在类的上面
 *
 *  SpringConfig这个类就相当于beans.xml
 *
 */

@Configuration
public class SpringConfig {
    /**
     * 创建方法，方法的返回值是对象。 在方法的上面加入@Bean
     * 方法的返回值对象就注入到容器中。
     *
     * @Bean: 把对象注入到spring容器中。 作用相当于<bean>
     *     也就是吧返回值放入容器之中
     *
     *     位置：方法的上面
     *
     *     说明：@Bean,不指定对象的名称，默认是方法名是 id
     *
     */
    @Bean
    public Student createStudent(){
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(34);
        student.setSex("男");
        return student;
    }

    /***
     * 指定对象在容器中的名称（指定<bean>的id属性）
     * @Bean的name属性，指定对象的名称（id）
     */
    @Bean(name = "lisiStudent")
    public Student makeStudent(){
        Student s2  = new Student();
        s2.setName("李四");
        s2.setAge(22);
        s2.setSex("男");
        return s2;
    }
}
