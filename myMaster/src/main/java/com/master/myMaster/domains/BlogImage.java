package com.master.myMaster.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogImage {

  private Long id;
  private String imageData;
  private Long blogId;
}
