package org.example.usertest.controller;

import lombok.RequiredArgsConstructor;
import org.example.usertest.dto.UserRespDto;
import org.example.usertest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
  private final UserService service;

  @GetMapping("/users")
  public List<UserRespDto> getAllUsers() {
    return service.getAllUsers();
  }

}
