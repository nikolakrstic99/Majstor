package com.master.myMaster.domains;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(
          shape = JsonFormat.Shape.STRING,
          pattern = "yyyy-MM-dd"
  )
  private LocalDateTime createdAt;
}
