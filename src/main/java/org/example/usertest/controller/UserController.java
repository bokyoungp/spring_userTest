package org.example.usertest.controller;

import lombok.RequiredArgsConstructor;
import org.example.usertest.dto.UserReqDto;
import org.example.usertest.dto.UserRespDto;
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

  @GetMapping(value = "/users", produces = MediaType.APPLICATION_XML_VALUE)
  public List<UserRespDto> getAllUsers() {
    return service.getAllUsers();
  }

  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public UserRespDto createNewUser(@RequestBody UserReqDto reqDto) {
    return service.createNewUser(reqDto);
  }

}
