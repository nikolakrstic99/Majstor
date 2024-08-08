package com.master.myMaster.common.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

  private final Error error;

  public BadRequestException(String msg, Error error) {
    super(msg);
    this.error = error;
  }
}