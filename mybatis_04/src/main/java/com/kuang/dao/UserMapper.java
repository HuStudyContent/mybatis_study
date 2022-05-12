package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

//操作数据库
public interface UserMapper {

  //分页查询插件测试
  List<User> queryByPage();

  //分页查询
  List<User> getUserByLimit(Map<String, Integer> map);

  //分页查询  第二种
  List<User> getUserByRowBounds();

  //查询所有用户
  List<User> getUserList();

  //根据id查询用户
  User getUserById(int id);

  //insert 插入一个用户
  int addUser(User user);


  //修改用户
  int updateUser(User user);

  //删除一个用户
  int deleteUser(int id);
}
