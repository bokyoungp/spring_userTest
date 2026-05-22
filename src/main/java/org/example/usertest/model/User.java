package org.example.usertest.model;

import lombok.*;

@Data
@AllArgsConstructor
public class User {
  private int id;
  private String userId;
  private String username;
  private String email;
}
