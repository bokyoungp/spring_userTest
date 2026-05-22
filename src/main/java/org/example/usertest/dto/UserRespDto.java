package org.example.usertest.dto;

import org.example.usertest.model.User;

public record UserRespDto(
    int id,
    String userId,
    String username
) {
  public static UserRespDto of(User user) {
    return new UserRespDto(
        user.getId(),
        user.getUserId(),
        user.getUsername()
    );
  }
}
