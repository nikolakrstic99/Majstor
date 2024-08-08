package com.master.myMaster.domains;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String token;
  private String password;
  private UserStatus status;
  @Builder.Default
  private Set<Blog> blogs = new HashSet<>();
}
