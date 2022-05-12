package com.kuang.dao;


import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//操作数据库
public interface UserMapper {

  @Select("select * from users")
  @Results(id="UserMap", value={
          @Result(property="password", column="pwd")
  })
  List<User> getUser();


  // 根据id查用户
  // 方法存在多个参数，所有参数前面必须加上 @Param("id") 注解 @Param("id") int id, @Param("name") String name
  @Select("select * from users where id = #{id}")
  @ResultMap(value = "UserMap" )
  User getUserById(@Param("id") int id);


  //增加用户
  @Insert("insert into users(id,name,pwd) values (#{id}, #{name}, #{password})")
  @ResultMap(value = "UserMap" )
  int addUser(User user);

  // 修改信息
  @Update("update users set name=#{name}, pwd=#{password} where id=#{id}")
  @ResultMap(value = "UserMap" )
  int updateUser(User user);

  // 删除用户
  @Delete("delete from users where id = #{uid} ")
  int deleteUser(@Param("uid") int id);
}
