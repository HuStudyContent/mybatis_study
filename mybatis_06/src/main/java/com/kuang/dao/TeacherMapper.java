package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

  // 查询
  @Select("select * from teacher where id=#{tid}")
  Teacher getTeacher(@Param("tid") int id);
}
