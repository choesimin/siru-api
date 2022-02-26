package com.simin.siru.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simin.siru.dto.ErrorResponse;
import com.simin.siru.exception.EmailDuplicatedException;
import com.simin.siru.exception.NameDuplicatedException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EmailDuplicatedException.class)
    public ResponseEntity<ErrorResponse> handleException(EmailDuplicatedException e) {
        return new ResponseEntity<>(new ErrorResponse("DUPLICATED_EMAIL"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NameDuplicatedException.class)
    public ResponseEntity<ErrorResponse> handleException(NameDuplicatedException e) {
        return new ResponseEntity<>(new ErrorResponse("DUPLICATED_NAME"), HttpStatus.BAD_REQUEST);
    }

}