package com.master.myMaster.mapper;

import com.master.myMaster.api.request.AddBlogRequest;
import com.master.myMaster.domains.Blog;
import com.master.myMaster.entities.BlogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BlogMapper {

  Blog toBlog(BlogEntity entity);

  BlogEntity toBlogEntity(Blog blog);

  Blog toBlog(AddBlogRequest request);
}
