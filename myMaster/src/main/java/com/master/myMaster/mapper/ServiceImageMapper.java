package com.master.myMaster.mapper;

import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.entities.ServiceImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceImageMapper {

  ServiceImageEntity toEntity(ServiceImage domain);

  ServiceImage toDomain(ServiceImageEntity entity);

}
