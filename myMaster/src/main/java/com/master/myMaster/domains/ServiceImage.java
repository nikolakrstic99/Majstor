package com.master.myMaster.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceImage {

  private Long id;
  private byte[] imageData;
  private Long serviceId;
}
