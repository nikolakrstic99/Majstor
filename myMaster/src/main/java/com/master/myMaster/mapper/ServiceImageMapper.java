package com.master.myMaster.mapper;

import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.entities.ServiceImageEntity;
import java.util.Base64;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServiceImageMapper {

  ServiceImageMapper INSTANCE = Mappers.getMapper(ServiceImageMapper.class);

  @Mapping(source = "imageData", target = "imageData", qualifiedByName = "decodeImage")
  ServiceImageEntity toEntity(ServiceImage serviceImage);

  @Mapping(source = "imageData", target = "imageData", qualifiedByName = "encodeImage")
  ServiceImage toDomain(ServiceImageEntity serviceImageEntity);

  @Named("decodeImage")
  default byte[] decodeImage(String base64Image) {
    return Base64.getDecoder().decode(base64Image.split(",")[1]);
  }

  @Named("encodeImage")
  default String encodeImage(byte[] image) {
    return "data:image/png;base64," + Base64.getEncoder().encodeToString(image);
  }
}
