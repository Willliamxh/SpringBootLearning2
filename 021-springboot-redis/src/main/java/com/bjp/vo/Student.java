package com.bjp.vo;

import java.io.Serializable;

/**
 * @Author Willam_xh
 * @Date 2022-05-18 15:06
 * 序列化版本号的用处：https://www.jianshu.com/p/11f2649849f8
 * 在 序列化存储/反序列化读取 或者是 序列化传输/反序列化接收 时，
 * JVM 会把传来的字节流中的serialVersionUID与本地相应实体（类）
 * 的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，
 * 否则就会出现序列化版本不一致的异常。
 *
 * 在对实体类进行不影响业务流程的升级时，比如只追加了一个附加信息字段，
 * 可以不改变序列化版本号，来实现新旧实体类的兼容性（接收方的类里没有的字段被舍弃；
 * 多出来的字段赋初始值）。
 *
1）在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。

　　2）当你序列化了一个类实例后，希望更改一个字段或添加一个字段，不设置serialVersionUID，所做的任何更改都将导致无法反序化旧有实例，并在反序列化时抛出一个异常。如果你添加了serialVersionUID，在反序列旧有实例时，新添加或更改的字段值将设为初始化值（对象为null，基本类型为相应的初始默认值），字段被删除将不设置。
 *
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
