package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserDaoTest {


  //测试注解查询
  @Test
  public void getUserTest(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    List<User> userList = Mapper.getUser();
    for(User user: userList){
      System.out.println(user);
    }
    sqlSession.close();
  }


  // 用id查询用户
  @Test
  public void getUserById(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    User userById = Mapper.getUserById(1);
    System.out.println(userById);

    sqlSession.close();
  }

  // 增加用户
  @Test
  public void addUserTest(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    Mapper.addUser(new User(6, "张子枫", "123456"));

    sqlSession.close();
  }

  // 修改信息
  @Test
  public void updateUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    Mapper.updateUser(new User(6, "张子枫妹妹", "123"));

    sqlSession.close();
  }

  // 删除用户
  @Test
  public void deleteUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    Mapper.deleteUser(5);

    sqlSession.close();
  }
}
