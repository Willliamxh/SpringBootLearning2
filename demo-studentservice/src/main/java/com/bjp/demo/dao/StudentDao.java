package com.bjp.demo.dao;

import com.bjp.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Willam_xh
 * @Date 2022-05-31 15:29
 */
public interface StudentDao {
    //按手机号作为添加查询
    Student selectByPhone(@Param("phone") String phone);

    int insertStudent(Student student);

}
