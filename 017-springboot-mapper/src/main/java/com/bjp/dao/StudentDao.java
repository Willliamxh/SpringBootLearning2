package com.bjp.dao;

import com.bjp.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Mapper：告诉MyBatis这是dao接口，创建此接口的代理对象。
 *     位置：在类的上面
 */
@Mapper
public interface StudentDao {
    //@Param是给之后的sql语句起别名
    Student selectById(@Param("stuId") Integer id);

}
