package com.bjp.demo.service.impl;

import com.bjp.demo.dao.StudentDao;
import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @Author Willam_xh
 * @Date 2022-05-31 11:27
 */

/**
 * 按照手机号添加学生
 * 1。添加成功
 * 2.手机号重复
 */
@DubboService(interfaceClass = StudentService.class,version = "1.0")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int res=0;
        //查询手机号是否唯一
        if (student.getPhone()!=null){
            Student student1 = studentDao.selectByPhone(student.getPhone());
            if(student1!=null){
                res=2;
            }else {
                //添加处理
                res=studentDao.insertStudent(student);
            }
        }else {
            res=3;
        }
        return res;
    }

    @Override
    public Student queryStudent(Integer id) {
        return null;
    }
}
