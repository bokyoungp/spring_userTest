package org.example.usertest.service;

import lombok.RequiredArgsConstructor;
import org.example.usertest.dto.UserRespDto;
import org.example.usertest.model.User;
import org.example.usertest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public List<UserRespDto> getAllUsers() {
    return repository.findAll()
        .stream()
        .map(UserRespDto::of)
        .toList();
  }

  public UserRespDto getUserById(int id) {
    User user = repository.findById(id);
    return UserRespDto.of(user);
  }
}
