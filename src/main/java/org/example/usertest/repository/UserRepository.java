package org.example.usertest.repository;

import org.example.usertest.model.User;

import java.util.List;

public interface UserRepository {
  List<User> findAll();
  User findById(int id);
  int insert(User user);
  void update(User user);
  void delete(int id);
}
