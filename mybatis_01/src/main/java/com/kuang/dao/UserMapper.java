package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

//操作数据库
public interface UserMapper {

  //模糊查询
  List<User> getUserLike(String value);

  //查询所有用户
  List<User> getUserList();

  //根据id查询用户
  User getUserById(int id);

  //用map实现条件查询
  User getUserById2(Map<String, Object> map);

  //insert 插入一个用户
  int addUser(User user);

  //万能的map
  int addUser2(Map<String, Object> map);

  //修改用户
  int updateUser(User user);

  //删除一个用户
  int deleteUser(int id);
}
