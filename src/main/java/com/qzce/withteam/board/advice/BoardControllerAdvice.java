package com.qzce.withteam.board.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice(basePackageClasses = [])
public class BoardControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public String exception(RuntimeException e) {
        return "server Error";
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>("Index Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
