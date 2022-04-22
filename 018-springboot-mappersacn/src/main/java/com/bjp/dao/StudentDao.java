package com.bjp.dao;

import com.bjp.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface StudentDao {
    //@Param是给之后的sql语句起别名
    Student selectById(@Param("stuId") Integer id);

}
