package org.example.usertest.service;

import lombok.RequiredArgsConstructor;
import org.example.usertest.model.User;
import org.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public List<User> getAllUsers() {
    return repository.findAll();
  }

  public User getUserById(int id) {
    return repository.findById(id);
  }
}
