package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handleException(BurgerException exception) {
        log.error(exception.getMessage());
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {
        log.error(exception.getMessage());
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
