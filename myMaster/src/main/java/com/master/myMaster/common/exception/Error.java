package com.master.myMaster.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public enum Error {
  RESOURCE_NOT_FOUND(Keys.RESOURCE_NOT_FOUND),
  INVALID_PASSWORD(Keys.INVALID_PASSWORD),
  USER_ALREADY_EXISTS(Keys.USER_ALREADY_EXISTS),
  SERVICE_ALREADY_EXISTS(Keys.SERVICE_ALREADY_EXISTS),
  REVIEW_ALREADY_EXISTS(Keys.REVIEW_ALREADY_EXISTS);

  private final String key;

  @UtilityClass
  public static final class Keys {
    public static final String RESOURCE_NOT_FOUND = "resource.not.found";
    public static final String INVALID_PASSWORD = "invalid.password";
    public static final String USER_ALREADY_EXISTS = "user.already.exists";
    public static final String SERVICE_ALREADY_EXISTS = "Servis vec postoji";
    public static final String REVIEW_ALREADY_EXISTS = "Vaš komentar o ovom korisniku vec postoji";
  }
}