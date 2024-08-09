package com.master.myMaster.repository;

import com.master.myMaster.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}