package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {



  @Test
  public void test(){
    // 第一步： 获得sqlSession 对象
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    //方式一： 执行sql， 获取了userDao
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);
    List<User> userList = Mapper.getUserList();

    for(User user: userList){
      System.out.println(user);
    }

    // 关闭sqlSession
    sqlSession.close();
  }


  @Test
  public void getUserById(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    User user1 = Mapper.getUserById(1);
    System.out.println(user1);

    sqlSession.close();
  }

  //增删改 需要提交事务
  //增加用户
  @Test
  public void addUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    int i = Mapper.addUser(new User(5,"唐嫣", "1234"));

    if(i > 0){
      System.out.println("插入成功");
    }

    //提交事务
    sqlSession.commit();
    sqlSession.close();
  }



  //修改
  @Test
  public void updateUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    Mapper.updateUser(new User(2,"大美女", "234"));

    //提交事务
    sqlSession.commit();
    sqlSession.close();
  }

  //删除
  @Test
  public void deleteUser(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    Mapper.deleteUser(2);

    //提交事务
    sqlSession.commit();
    sqlSession.close();
  }

}
