package com.master.myMaster.service;

import com.master.myMaster.domains.Image;
import com.master.myMaster.mapper.ImageMapper;
import com.master.myMaster.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

  private final ImageRepository imageRepository;
  private final ImageMapper imageMapper;

  public void save(Image image) {
    imageRepository.save(imageMapper.toImageEntity(image));
  }
}
