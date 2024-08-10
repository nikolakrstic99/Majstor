package com.master.myMaster.api.controller;

import com.master.myMaster.utils.Utils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/service")
public class ServiceController {

  @GetMapping("/l1Categories")
  public List<String> getL1Categories() {
    return Utils.getL1Categories();
  }

  @GetMapping("/l2Categories")
  public List<String> getL2Categories(@RequestParam String l1Category) {
    return Utils.getL2Categories(l1Category);
  }
}
