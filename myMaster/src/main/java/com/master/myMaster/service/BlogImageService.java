package com.master.myMaster.service;

import com.master.myMaster.domains.BlogImage;
import com.master.myMaster.entities.BlogImageEntity;
import com.master.myMaster.mapper.BlogImageMapper;
import com.master.myMaster.repository.BlogImageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogImageService {

  private final BlogImageRepository blogImageRepository;
  private final BlogImageMapper blogImageMapper;

  @Transactional
  public void save(BlogImageEntity blogImageEntity) {
    blogImageRepository.save(blogImageEntity);
  }

  @Transactional
  public List<BlogImage> getImages(Long id) {
    return blogImageRepository.findByBlogId(id).stream().map(blogImageMapper::toDomain)
        .toList();
  }

  @Transactional
  public void deleteImagesWithBlogId(Long id) {
    blogImageRepository.deleteByBlogId(id);
  }

}
