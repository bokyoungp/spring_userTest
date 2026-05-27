package org.example.usertest.service;

import org.assertj.core.api.Assertions;
import org.example.usertest.dto.UserReqDto;
import org.example.usertest.dto.UserRespDto;
import org.example.usertest.model.User;


import org.example.usertest.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
  @Autowired
  UserService service;

  @Autowired
  UserRepository repository;

  @BeforeAll
  static void init(){
    System.out.println("테스트 객체 생성전 - init()");
  }

  @BeforeEach
  void setUp() {
    System.out.println("단위 테스트 실행 전 - beforeEach()");
  }

  @AfterEach
  void tearDown() {
    System.out.println("단위 테스트 실행 후 - afterEach()");
  }

//  @Test
//  @DisplayName("id 로 사용자 정보 가져오기 테스트")
//  void getUserById() {
//    System.out.println("단위 테스트 - getUserById()");
//    //given
//    UserReqDto user = new UserReqDto("bbb", "kim", "bb@naver.com");
//    UserRespDto newUser = service.createNewUser(user);
//    System.out.println(newUser);
//    // when
//    UserRespDto userById = service.getUserById(newUser.id());
//    // then
//    Assertions.assertThat(userById.userId()).isEqualTo(newUser.userId());
//  }

//  @Test
//  @DisplayName("전체 사용자 정보 가져오기 테스트")
//  void getAllUsers() {
//    System.out.println("단위 테스트 - getAllUsers()");
//    // given
//    UserReqDto user = new UserReqDto("aaa", "hong", "aa@naver.com");
//    service.createNewUser(user);
//    // when
//    List<UserRespDto> allUsers = service.getAllUsers();
//    // then
//    Assertions.assertThat(allUsers.size()).isEqualTo(1);
//  }

  @Test
  @DisplayName("부서명에 따라 동적으로 동작하는 메서드 테스트")
  void getUsersByDeptDynamic() {
    // given

    // when
    List<UserRespDto> users = service.getAllUsersByDeptDynamic("HR", null);
    List<UserRespDto> users2 = service.getAllUsersByDeptDynamic(null, null);
    List<UserRespDto> users3 = service.getAllUsers();
    // then
    Assertions.assertThat(users.size()).isEqualTo(2);
    Assertions.assertThat(users2.size()).isEqualTo(users3.size());
  }


  @AfterAll
  static void destroy(){
    System.out.println("테스트 완료");
  }

}