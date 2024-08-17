package com.master.myMaster.service;

import com.master.myMaster.api.request.AddServiceRequest;
import com.master.myMaster.common.exception.BadRequestException;
import com.master.myMaster.common.exception.Error;
import com.master.myMaster.domains.Service;
import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.ServiceEntity;
import com.master.myMaster.mapper.ServiceImageMapper;
import com.master.myMaster.mapper.ServiceMapper;
import com.master.myMaster.mapper.UserMapper;
import com.master.myMaster.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {

  private final ServiceRepository serviceRepository;
  private final ServiceMapper serviceMapper;
  private final UserService userService;
  private final UserMapper userMapper;
  private final ServiceImageMapper serviceImageMapper;
  private final ServiceImageService serviceImageService;

  @Transactional
  public Service addService(AddServiceRequest addServiceRequest, User principalUser) {
    var service = serviceMapper.toDomain(addServiceRequest);
    var user = userService.findByEmail(principalUser.getEmail());
    if (serviceExists(user.getId(), service.getL2Category())) {
      throw new BadRequestException("User already provides service in this category", Error.USER_ALREADY_EXISTS);
    }
    service.setUser(user);
    user.addService(service);
    var serviceEntity = save(serviceMapper.toEntity(service));
    for (var file : addServiceRequest.files()) {
      var serviceImage = new ServiceImage();
      serviceImage.setServiceId(serviceEntity.getId());
      serviceImage.setImageData(file);
      serviceImageService.save(serviceImageMapper.toEntity(serviceImage));
    }
    return service;
  }

  private boolean serviceExists(Long userId, String l2Category) {
    return serviceRepository.existsByUserIdAndL2Category(userId, l2Category);
  }

  @Transactional
  public ServiceEntity save(ServiceEntity serviceEntity) {
    return serviceRepository.save(serviceEntity);
  }

  @Transactional
  public List<Service> getUsersProvidingL1Category(String l1Category) {
    return serviceRepository
        .findByL1Category(l1Category)
        .stream()
        .map(serviceMapper::toDomain)
        .collect(Collectors.toMap(
            Service::getUser,
            Function.identity(),
            (existing, replacement) -> existing
        ))
        .values()
        .stream()
        .toList();
  }

  @Transactional
  public List<Service> getUsersProvidingL2Category(String l2Category) {
    return serviceRepository
        .findByL2Category(l2Category)
        .stream()
        .map(serviceMapper::toDomain)
        .toList();
  }

  @Transactional
  public List<Service> getServicesProvidedByUser(Integer userId) {
    return serviceRepository.findByUserId(userId.longValue())
        .stream()
        .map(serviceMapper::toDomain)
        .toList();
  }

  @Transactional
  public void deleteService(Long id) {
    serviceRepository.deleteById(id);
  }
}
