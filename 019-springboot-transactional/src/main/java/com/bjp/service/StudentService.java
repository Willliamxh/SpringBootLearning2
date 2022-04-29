package com.bjp.service;

import com.bjp.model.Student;

public interface StudentService {
    int addStudent(Student student);
    Student queryStudent(int id);

}
