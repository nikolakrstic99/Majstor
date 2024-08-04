package com.master.myMaster.domains;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

  private Long id;
  private String heading;
  private String subHeading;
  private String details;
  private User user;
  private LocalDateTime createdAt;
}
