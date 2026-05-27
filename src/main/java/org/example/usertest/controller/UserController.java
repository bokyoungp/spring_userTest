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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
  private final UserService service;

  @GetMapping(value = "/users")
  public String getAllUsers(Model model) {
    model.addAttribute("userList", service.getAllUsers());
    return "userList";
  }

  @GetMapping("/users/dynamicSearch")
  public String getAllUsersByDeptDynamic(@RequestParam(value="dept", required = false) String dept,
                                         @RequestParam(value="age", required = false) Integer age,
                                         Model model){
    model.addAttribute("userList", service.getAllUsersByDeptDynamic(dept, age));
    return "userList";
  }

//  @GetMapping({"/users/dept/{dept}", "/users/dept/"})
//  public List<UserRespDto> getAllUsersByDeptDynamic(@PathVariable(value="dept", required = false) String dept) {
//    return service.getAllUsersByDeptDynamic(dept);
//  }


  @GetMapping("/users/{id}")
  public String getOneUser(@PathVariable("id") int id, Model model) {
    model.addAttribute("user",service.getUserById(id));
    return "userInfo";
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
