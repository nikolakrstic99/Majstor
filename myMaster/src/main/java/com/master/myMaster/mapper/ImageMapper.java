package com.master.myMaster.mapper;

import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.entities.BlogImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

  BlogImageEntity toImageEntity(BlogImage blogImage);

  BlogImage toDomain(BlogImageEntity entity);
}
