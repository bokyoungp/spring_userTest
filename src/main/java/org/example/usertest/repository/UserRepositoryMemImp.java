package org.example.usertest.repository;

import org.example.usertest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
//public class UserRepositoryMemImp implements UserRepository {
//  private static Map<Integer, User> users = new HashMap<>();
//  private static int seq = 0;
//
//  @Override
//  public List<User> findAll() {
//    return new ArrayList<>(users.values());
//  }
//
//  @Override
//  public User findById(int id) {
//    return users.get(id);
//  }
//
//  @Override
//  public int insert(User user) {
//    user.setId(++seq);
//    users.put(user.getId(), user);
//    return user.getId();
//  }
//
//  @Override
//  public void update(User user) {
//    users.put(user.getId(), user);
//  }
//
//  @Override
//  public void delete(int id) {
//    users.remove(id);
//  }
//
//  @Override
//  public List<User> findAllByDept(String dept) {
//    return List.of();
//  }
//
//  @Override
//  public List<User> findAllByDeptDynamic(String dept) {
//    return List.of();
//  }
//}
