package com.master.myMaster.mapper;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.entities.BlogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BlogMapper {

  Blog toBlog(BlogEntity entity);

  BlogEntity toBlogEntity(Blog blog);

  Blog toBlog(AddBlogRequest request);
}
