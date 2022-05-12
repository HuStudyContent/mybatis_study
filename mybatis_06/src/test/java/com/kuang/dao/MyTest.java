package com.kuang.dao;

import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

  @Test
  public void getTeacher(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

    Teacher teacher = teacherMapper.getTeacher(1);
    System.out.println(teacher);

    sqlSession.close();
  }

  @Test
  public void getAllStudents(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    List<Student> students = studentMapper.getStudents();
    for(Student student: students){
      System.out.println(student);
    }

    sqlSession.close();
  }

  @Test
  public void getAllStudents2(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    List<Student> students2 = studentMapper.getStudent2();
    for(Student student2: students2){
      System.out.println(student2);
    }

    sqlSession.close();
  }

  @Test
  public void getStudentById(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    Student students3 = studentMapper.getStudentClass(1);
    System.out.println(students3);

    sqlSession.close();
  }
}
