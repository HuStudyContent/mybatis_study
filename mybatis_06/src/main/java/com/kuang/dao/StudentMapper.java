package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;

public interface StudentMapper {

  //查询所有学生信息，以及对应的老师信息
  public List<Student> getStudents();


  public List<Student> getStudent2();

  Student getStudentClass(int id);
}
