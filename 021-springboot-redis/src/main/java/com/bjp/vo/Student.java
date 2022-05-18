package com.bjp.vo;

import java.io.Serializable;

/**
 * @Author Willam_xh
 * @Date 2022-05-18 15:06
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -1071267682012590359L;

    private Integer id;
    private String name;
    private Integer age;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
