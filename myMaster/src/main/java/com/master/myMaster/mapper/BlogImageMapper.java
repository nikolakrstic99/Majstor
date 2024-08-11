package com.master.myMaster.mapper;

import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.entities.BlogImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogImageMapper {

  BlogImageEntity toEntity(BlogImage domain);

  BlogImage toDomain(BlogImageEntity entity);
}
