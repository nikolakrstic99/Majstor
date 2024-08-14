package com.master.myMaster.repository;

import com.master.myMaster.entities.ServiceEntity;
import com.master.myMaster.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findByL1Category(String l1Category);
    List<ServiceEntity> findByL2Category(String l2Category);
    List<ServiceEntity> findByUser(UserEntity user_id);
}
