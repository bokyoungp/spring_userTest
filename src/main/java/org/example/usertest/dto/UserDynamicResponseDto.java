package org.example.usertest.dto;

import org.example.usertest.model.User;

public record UserDynamicResponseDto(
    String userId,
    String username,
    String dept,
    Integer age
) {
  public static UserDynamicResponseDto of(User user) {
    return new UserDynamicResponseDto(
        user.getUserId(),
        user.getUsername(),
        user.getDept(),
        user.getAge()
    );
  }
}
