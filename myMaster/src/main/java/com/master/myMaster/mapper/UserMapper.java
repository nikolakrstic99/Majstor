package com.master.myMaster.mapper;

import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toUser(UserEntity entity);

  //@Mapping(target = "password", ignore = true)
  UserEntity toUserEntity(User user);

  //@Mapping(target = "password", ignore = true)
  UserEntity signUpRequestToUser(SignUpRequest signUp);
}
