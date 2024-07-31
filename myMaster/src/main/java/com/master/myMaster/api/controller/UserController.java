package com.master.myMaster.api.controller;

import com.master.myMaster.api.request.CredentialsRequest;
import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.common.config.UserAuthProvider;
import com.master.myMaster.domains.UserDto;
import com.master.myMaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserAuthProvider userAuthProvider;

  @GetMapping("/test")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok("Hello");
  }

  @PostMapping("/login")
  public ResponseEntity<UserDto> login(@RequestBody CredentialsRequest credentials) {
    var user = userService.login(credentials);
    user.setToken(userAuthProvider.createToken(user));
    return ResponseEntity.ok(user);
  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> register(@RequestBody SignUpRequest signUp) {
    var user = userService.register(signUp);
    user.setToken(userAuthProvider.createToken(user));
    return ResponseEntity.ok(user);
  }

}
