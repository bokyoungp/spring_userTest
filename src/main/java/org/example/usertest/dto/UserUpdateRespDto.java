package org.example.usertest.dto;

import org.example.usertest.model.User;

public record UserUpdateRespDto(
    String userId,
    String username,
    String email
) {
  public static UserUpdateRespDto of(User user) {
    return new UserUpdateRespDto(
        user.getUserId(),
        user.getUsername(),
        user.getEmail()
    );
  }
}
