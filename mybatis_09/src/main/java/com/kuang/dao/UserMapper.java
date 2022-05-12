package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

  //根据id查询用户
  User queryUserById(@Param("id") int id);

  // 修改用户
  int updateUser(User user);

}
