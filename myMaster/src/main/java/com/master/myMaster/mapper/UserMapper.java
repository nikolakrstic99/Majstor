package com.master.myMaster.mapper;

import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toDomain(UserEntity entity);

  UserEntity toEntity(User user);

  UserEntity signUpRequestToUser(SignUpRequest signUp);
}
