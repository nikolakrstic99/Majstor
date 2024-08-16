package com.master.myMaster.mapper;

import com.master.myMaster.api.request.SignUpRequest;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

//  @Mapping(target = "blogs", ignore = true)
  User toDomain(UserEntity entity);

 // @Mapping(target = "blogs", ignore = true)
  UserEntity toEntity(User user);

  UserEntity signUpRequestToUser(SignUpRequest signUp);
}
