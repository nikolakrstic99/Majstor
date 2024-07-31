package com.master.myMaster.common.exception;

import com.master.myMaster.common.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  @ResponseBody
  public ResponseEntity<ErrorDto> handleException(BadRequestException e) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorDto(e.getMessage()));
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  public ResponseEntity<ErrorDto> handleException(NotFoundException e) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorDto(e.getMessage()));
  }
}
