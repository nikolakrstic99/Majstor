package com.master.myMaster.api.controller;

import com.master.myMaster.utils.Utils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/service")
public class ServiceController {

  @GetMapping("/l1Categories")
  public List<String> getL1Categories() {
    return Utils.getL1Categories();
  }

  @GetMapping("/l2Categories/{l1Category}")
  public List<String> getL2Categories(@PathVariable String l1Category) {
    return Utils.getL2Categories(l1Category);
  }
}
