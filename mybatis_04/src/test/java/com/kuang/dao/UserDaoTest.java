package com.kuang.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {

  static Logger logger = Logger.getLogger(UserDaoTest.class);

  //测试分页
  @Test
  public void getUserByLimit(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("startIndex", 0);
    map.put("pageSize", 2);

    List<User> userList = Mapper.getUserByLimit(map);
    for(User user: userList){
      System.out.println(user);
    }
    sqlSession.close();

  }

  //实现分类二
  @Test
  public void getUserByRowBounds(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();

    //RowBounds 实现
    RowBounds rowBounds = new RowBounds(1,2);

    //通过java代码层面实现分类
    List<User> userList = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds", null, rowBounds);

    for(User user: userList){
      System.out.println(user);
    }
    sqlSession.close();

  }

  // 测试分页插件实现分页
  @Test
  public void queryByPage(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper Mapper = sqlSession.getMapper(UserMapper.class);

    PageHelper.startPage(1, 2);
    List<User> userList = Mapper.queryByPage();
    PageInfo<User> pageInfo = new PageInfo<User>(userList);
    System.out.println(pageInfo);

    sqlSession.close();
  }



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
    logger.debug("debug: 进入了testLog4j");
    User user1 = Mapper.getUserById(1);
    System.out.println(user1);

    sqlSession.close();
  }

  //测试日志
  @Test
  public void testLog4j(){
    logger.info("info: 进入了testLog4j");
    logger.debug("debug: 进入了testLog4j");
    logger.error("error: 进入了testLog4j");
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
