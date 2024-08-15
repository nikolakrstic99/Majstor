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
  private String phone;
  private String location;
  @Builder.Default
  private Set<Blog> blogs = new HashSet<>();
  @Builder.Default
  private Set<Service> services = new HashSet<>();

  public void addBlog(Blog blog) {
    blogs.add(blog);
  }

  public void addService(Service service) {
    services.add(service);
  }
}
