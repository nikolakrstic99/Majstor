package com.master.myMaster.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {
  REGULAR("REGULAR"),
  ADMIN("ADMIN");

  private final String value;

  @Override
  public String toString() {
    return value;
  }
}
