package org.example.usertest.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.usertest.dto.UserReqDto;
import org.example.usertest.dto.UserRespDto;
import org.example.usertest.dto.UserUpdateReqDto;
import org.example.usertest.dto.UserUpdateRespDto;
import org.example.usertest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
  private final UserService service;

  @GetMapping(value = "/users") // produces = MediaType.APPLICATION_XML_VALUE)
  public List<UserRespDto> getAllUsers() {
    return service.getAllUsers();
  }

  @GetMapping("/users/{id}")
  public UserRespDto getOneUser(@PathVariable("id") int id) {
    return service.getUserById(id);
  }

  @GetMapping({"/users/dept/{dept}", "/users/dept/"})
  public List<UserRespDto> getAllUsersByDeptDynamic(@PathVariable(value="dept", required = false) String dept) {
    return service.getAllUsersByDeptDynamic(dept);
  }

  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public UserRespDto createNewUser(@RequestBody UserReqDto reqDto) {
    return service.createNewUser(reqDto);
  }

  @PutMapping("/users/{id}")
  public UserUpdateRespDto updateUser(@PathVariable("id") int id, @RequestBody UserUpdateReqDto reqDto) {
    return service.updateUser(reqDto);
  }

  @DeleteMapping("/users/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable int id) {
    service.deleteUser(id);
  }
}
