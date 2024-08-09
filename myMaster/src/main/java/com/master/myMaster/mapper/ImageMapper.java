package com.master.myMaster.mapper;

import com.master.myMaster.domains.Image;
import com.master.myMaster.entities.ImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

  ImageEntity toImageEntity(Image image);

  Image toDomain(ImageEntity entity);
}
