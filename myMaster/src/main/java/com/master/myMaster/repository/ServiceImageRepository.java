package com.master.myMaster.repository;

import com.master.myMaster.entities.ServiceImageEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceImageRepository extends JpaRepository<ServiceImageEntity, Long> {

  List<ServiceImageEntity> findByServiceId(Long id);

  void deleteByServiceId(Long id);

}
