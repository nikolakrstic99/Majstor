package com.master.myMaster.service;

import com.master.myMaster.api.request.AddServiceRequest;
import com.master.myMaster.domains.Service;
import com.master.myMaster.domains.ServiceImage;
import com.master.myMaster.domains.User;
import com.master.myMaster.entities.ServiceEntity;
import com.master.myMaster.entities.UserEntity;
import com.master.myMaster.mapper.ServiceImageMapper;
import com.master.myMaster.mapper.ServiceMapper;
import com.master.myMaster.mapper.UserMapper;
import com.master.myMaster.repository.ServiceRepository;
import com.master.myMaster.utils.Utils;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {

  private final ServiceRepository serviceRepository;
  private final ServiceMapper serviceMapper;
  private final UserService userService;
  private final UserMapper userMapper;
  private final ServiceImageMapper serviceImageMapper;
  private final ServiceImageService serviceImageService;

  public Service addService(AddServiceRequest addServiceRequest, User principalUser) {
    var service = serviceMapper.toDomain(addServiceRequest);
    var user = userService.findByEmail(principalUser.getEmail());
    service.setUser(user);
    user.addService(service);
    var serviceEntity = save(serviceMapper.toEntity(service));
    for (var file : addServiceRequest.files()) {
      var serviceImage = new ServiceImage();
      serviceImage.setServiceId(serviceEntity.getId());
      serviceImage.setImageData(Utils.decodeImage(file));
      serviceImageService.save(serviceImageMapper.toEntity(serviceImage));
    }
    return service;
  }

  public ServiceEntity save(ServiceEntity serviceEntity) {
    return serviceRepository.save(serviceEntity);
  }

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

  public List<Service> getUsersProvidingL2Category(String l2Category) {
    return serviceRepository
            .findByL2Category(l2Category)
            .stream()
            .map(serviceMapper::toDomain)
            .toList();
  }

  public List<Service> getServicesProvidedByUser(Integer userId) {
    var user = userService.getUser(userId.longValue());
    return serviceRepository
            .findByUser(userMapper.toEntity(user))
            .stream()
            .map(serviceMapper::toDomain)
            .toList();
  }
}
