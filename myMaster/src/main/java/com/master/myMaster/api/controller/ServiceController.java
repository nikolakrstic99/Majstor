package com.master.myMaster.api.controller;

import com.master.myMaster.api.request.AddServiceRequest;
import com.master.myMaster.common.config.UserAuthProvider;
import com.master.myMaster.domains.Service;
import com.master.myMaster.service.ServiceService;
import com.master.myMaster.utils.Utils;
import jakarta.websocket.server.PathParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/service")
public class ServiceController {

  private final ServiceService serviceService;
  private final UserAuthProvider userAuthProvider;

  @GetMapping("/l1Categories")
  public List<String> getL1Categories() {
    return Utils.getL1Categories();
  }

  @GetMapping("/l2Categories/{l1Category}")
  public List<String> getL2Categories(@PathVariable String l1Category) {
    return Utils.getL2Categories(l1Category);
  }

  @PostMapping
  public ResponseEntity<Service> addService(@RequestBody AddServiceRequest addServiceRequest) {
    return ResponseEntity.ok(serviceService.addService(addServiceRequest, userAuthProvider.getUser()));
  }

  @GetMapping("/usersProvidingL1Category/{l1Category}")
  public List<Service> getUsersProvidingL1Category(@PathVariable String l1Category) {
    return serviceService.getUsersProvidingL1Category(l1Category);
  }

  @GetMapping("/usersProvidingL2Category/{l2Category}")
  public List<Service> getUsersProvidingL2Category(@PathVariable String l2Category) {
    return serviceService.getUsersProvidingL2Category(l2Category);
  }
}
