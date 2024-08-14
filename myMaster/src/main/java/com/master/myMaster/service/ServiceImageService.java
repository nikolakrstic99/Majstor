package com.master.myMaster.service;

import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.entities.ServiceImageEntity;
import com.master.myMaster.mapper.ServiceImageMapper;
import com.master.myMaster.repository.BlogImageRepository;
import com.master.myMaster.repository.ServiceImageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceImageService {

  private final ServiceImageRepository serviceImageRepository;
  private final ServiceImageMapper serviceImageMapper;

  public void save(ServiceImageEntity serviceImageEntity) {
    serviceImageRepository.save(serviceImageEntity);
  }

  @Transactional
  public List<ServiceImage> getImages(Long id) {
    return serviceImageRepository.findByServiceId(id).stream().map(serviceImageMapper::toDomain)
        .toList();
  }
}
