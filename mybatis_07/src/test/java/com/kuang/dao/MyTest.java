package com.kuang.dao;

import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class MyTest {

  @Test
  public void getTeachers(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

    List<Teacher> teachers = teacherMapper.getTeachers();

    for (Teacher teacher:teachers){
      System.out.println(teacher);
    }

    sqlSession.close();
  }


  // 方式一：   获取指定老师下的所有学生以及老师的信息
  @Test
  public void getTeacherById(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

    Teacher teacher1 = Mapper.getTeacherById(1);
    System.out.println(teacher1);

    sqlSession.close();
  }

  // 方式二：   获取指定老师下的所有学生以及老师的信息
  @Test
  public void getTeacherById2(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TeacherMapper Mapper = sqlSession.getMapper(TeacherMapper.class);

    Teacher teacher2 = Mapper.getTeacherById2(2);
    System.out.println(teacher2);

    sqlSession.close();
  }
}
