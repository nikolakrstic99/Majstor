package com.master.myMaster.mapper;

import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.entities.UserEntity;
import com.master.myMaster.domains.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toUser(UserEntity entity);

  @Mapping(target = "password", ignore = true)
  UserEntity signUpRequestToUser(SignUpRequest signUp);
}
