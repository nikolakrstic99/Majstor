package com.master.myMaster.domains;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service {

  private Long id;
  private String l1Category;
  private String l2Category;
  private String description;
  private User user;
}
