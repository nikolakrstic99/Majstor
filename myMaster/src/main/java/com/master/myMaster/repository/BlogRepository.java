package com.master.myMaster.repository;

import com.master.myMaster.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}
