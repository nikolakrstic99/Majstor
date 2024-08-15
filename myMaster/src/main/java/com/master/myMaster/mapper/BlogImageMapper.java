package com.master.myMaster.mapper;

import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.entities.BlogImageEntity;
import java.util.Base64;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BlogImageMapper {

  ServiceImageMapper INSTANCE = Mappers.getMapper(ServiceImageMapper.class);

  @Mapping(source = "imageData", target = "imageData", qualifiedByName = "decodeImage")
  BlogImageEntity toEntity(BlogImage domain);

  @Mapping(source = "imageData", target = "imageData", qualifiedByName = "encodeImage")
  BlogImage toDomain(BlogImageEntity entity);

  @Named("decodeImage")
  default byte[] decodeImage(String base64Image) {
    return Base64.getDecoder().decode(base64Image.split(",")[1]);
  }

  @Named("encodeImage")
  default String encodeImage(byte[] image) {
    return "data:image/png;base64," + Base64.getEncoder().encodeToString(image);
  }
}
