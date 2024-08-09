package com.master.myMaster.service;

import com.master.myMaster.api.request.CredentialsRequest;
import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.common.exception.BadRequestException;
import com.master.myMaster.common.exception.Error;
import com.master.myMaster.common.exception.NotFoundException;
import com.master.myMaster.domains.User;
import com.master.myMaster.domains.UserStatus;
import com.master.myMaster.mapper.UserMapper;
import com.master.myMaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;

  public User login(CredentialsRequest credentials) {
    var entity = userRepository.findByEmail(credentials.email())
      .orElseThrow(() -> new NotFoundException("Invalid password", Error.RESOURCE_NOT_FOUND));
    if (passwordEncoder.matches(credentials.password(), entity.getPassword())) {
      return userMapper.toDomain(entity);
    }
    throw new BadRequestException("User not found", Error.INVALID_PASSWORD);
  }

  public User register(SignUpRequest signUp) {
    if (userRepository.findByEmail(signUp.email()).isPresent()) {
      throw new BadRequestException("User already exists", Error.USER_ALREADY_EXISTS);
    }
    var userEntity = userMapper.signUpRequestToUser(signUp);
    userEntity.setPassword(passwordEncoder.encode(signUp.password()));
    userEntity.setStatus(UserStatus.REGULAR);
    userRepository.save(userEntity);
    return userMapper.toDomain(userEntity);
  }

  public User getUser(Long id) {
    return userMapper.toDomain(userRepository.findById(id).orElseThrow());
  }

  public User findByEmail(String email) {
    return userMapper.toDomain(userRepository.findByEmail(email).orElseThrow());
  }

  public void save(User user) {
    userRepository.save(userMapper.toEntity(user));
  }
}
