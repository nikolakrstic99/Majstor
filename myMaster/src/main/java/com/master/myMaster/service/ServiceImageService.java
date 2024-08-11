package com.master.myMaster.service;

import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.entities.ServiceImageEntity;
import com.master.myMaster.mapper.ServiceImageMapper;
import com.master.myMaster.repository.BlogImageRepository;
import com.master.myMaster.repository.ServiceImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceImageService {

  private final ServiceImageRepository serviceImageRepository;

  public void save(ServiceImageEntity serviceImageEntity) {
    serviceImageRepository.save(serviceImageEntity);
  }
}
