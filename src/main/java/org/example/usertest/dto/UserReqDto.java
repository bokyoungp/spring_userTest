package org.example.usertest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public record UserReqDto(
    String userId,
    String username,
    String email
) {}
