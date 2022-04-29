package com.bjp.service.impl;

import com.bjp.dao.StudentMapper;
import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 默认bean名称第一个字母小写
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentDao;

    /**
     *
     * @Transactional：表示方法有事务支持
     *  默认：使用数据库隔离级别   required 传播行为 超时时间
     *  抛出运行时异常 回滚事务
     *
     */
    @Transactional
    @Override
    public int addStudent(Student student) {
        System.out.println("业务方法addStudent");
        int rows = studentDao.insert(student);
        System.out.println("执行sql语句");


        //抛出一个运行异常，回滚事务
        // int m=10/0;


        return rows;
    }

    @Override
    public Student queryStudent(int id) {
        Student student = studentDao.selectByPrimaryKey(id);
        return student;
    }
}
