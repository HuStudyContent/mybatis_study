package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface TeacherMapper {

  // 查询老师
  List<Teacher> getTeachers();

  // 获取指定老师下的所有学生以及老师的信息
  Teacher getTeacherById(@Param("tid") int tid);


  Teacher getTeacherById2(@Param("tid") int tid);
}
