package com.bjp.service.impl;

import com.bjp.dao.StudentDao;
import com.bjp.model.Student;
import com.bjp.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryStudent(Integer id) {
        Student student=studentDao.selectById(id);
        return student;
    }
}
