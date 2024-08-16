package com.master.myMaster.mapper;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.entities.BlogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface BlogMapper {

  @Mapping(target = "user.id", source = "user.id")
  Blog toBlog(BlogEntity entity);

  @Mapping(target = "user.id", source = "user.id")
  BlogEntity toBlogEntity(Blog blog);

  @Mapping(target = "createdAt", ignore = true)
  Blog toBlog(AddBlogRequest request);
}
