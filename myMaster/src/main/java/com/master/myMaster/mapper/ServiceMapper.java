package com.master.myMaster.mapper;

import com.master.myMaster.api.request.AddServiceRequest;
import com.master.myMaster.domains.Service;
import com.master.myMaster.entities.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

  Service toDomain(ServiceEntity entity);

  ServiceEntity toEntity(Service service);

  Service toDomain(AddServiceRequest request);
}
