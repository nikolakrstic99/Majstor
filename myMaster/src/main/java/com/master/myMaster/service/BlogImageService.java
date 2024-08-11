package com.master.myMaster.service;

import com.master.myMaster.entities.BlogImageEntity;
import com.master.myMaster.repository.BlogImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogImageService {

  private final BlogImageRepository blogImageRepository;

  @Transactional
  public void save(BlogImageEntity blogImageEntity) {
    blogImageRepository.save(blogImageEntity);
  }

}
