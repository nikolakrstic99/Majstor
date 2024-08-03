package com.master.myMaster.service;

import com.master.myMaster.api.request.CredentialsRequest;
import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.common.exception.BadRequestException;
import com.master.myMaster.common.exception.Error;
import com.master.myMaster.common.exception.NotFoundException;
import com.master.myMaster.domains.UserDto;
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

  public UserDto login(CredentialsRequest credentials) {
    var entity = userRepository.findByEmail(credentials.email())
      .orElseThrow(() -> new NotFoundException("Invalid password", Error.RESOURCE_NOT_FOUND));
    if (passwordEncoder.matches(credentials.password(), entity.getPassword())) {
      return userMapper.toUser(entity);
    }
    throw new BadRequestException("User not found", Error.INVALID_PASSWORD);
  }

  public UserDto register(SignUpRequest signUp) {
    if (userRepository.findByEmail(signUp.email()).isPresent()) {
      throw new BadRequestException("User already exists", Error.USER_ALREADY_EXISTS);
    }
    var userEntity = userMapper.signUpRequestToUser(signUp);
    userEntity.setPassword(passwordEncoder.encode(signUp.password()));
    userRepository.save(userEntity);
    return userMapper.toUser(userEntity);
  }

  public UserDto getUser(Long id) {
    return userMapper.toUser(userRepository.findById(id).orElseThrow());
  }
}
