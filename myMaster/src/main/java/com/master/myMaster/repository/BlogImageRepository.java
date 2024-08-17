package com.master.myMaster.repository;

import com.master.myMaster.entities.BlogImageEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogImageRepository extends JpaRepository<BlogImageEntity, Long> {

  List<BlogImageEntity> findByBlogId(Long id);

  void deleteByBlogId(Long id);

}