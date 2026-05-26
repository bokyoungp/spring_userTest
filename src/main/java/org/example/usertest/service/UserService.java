package org.example.usertest.service;

import lombok.RequiredArgsConstructor;
import org.example.usertest.dto.UserReqDto;
import org.example.usertest.dto.UserRespDto;
import org.example.usertest.dto.UserUpdateReqDto;
import org.example.usertest.dto.UserUpdateRespDto;
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

  public List<UserRespDto> getAllUsersByDeptDynamic(String dept) {
    return repository.findAllByDeptDynamic(dept)
        .stream()
        .map(UserRespDto::of)
        .toList();
  }

  public UserRespDto getUserById(int id) {
    User user = repository.findById(id);
    return UserRespDto.of(user);
  }

  public UserRespDto createNewUser(UserReqDto reqDto) {
    User user = new User(0, reqDto.userId(), reqDto.username(), reqDto.email(), 20, "IT");
    int numOfRows = repository.insert(user);
    System.out.println(user);
//    user.setId(numOfRows);
    return UserRespDto.of(user);
  }

  public void deleteUser(int id) {
    repository.delete(id);
  }

  public UserUpdateRespDto updateUser(UserUpdateReqDto reqDto) {
    User user = repository.findById(reqDto.id());
    user.setEmail(reqDto.email());
    repository.update(user);
    return UserUpdateRespDto.of(user);
  }
}
