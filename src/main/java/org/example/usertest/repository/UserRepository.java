package org.example.usertest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.usertest.model.User;

import java.util.List;

@Mapper
public interface UserRepository {
  List<User> findAll();
  @Select("SELECT id, user_id, username, email, age, dept FROM user WHERE id = #{id}")
  User findById(int id);
  int insert(User user);
  void update(User user);
  void delete(int id);
  List<User> findAllByDept(String dept);
  List<User> findAllByDeptDynamic(String dept, Integer age);
}
