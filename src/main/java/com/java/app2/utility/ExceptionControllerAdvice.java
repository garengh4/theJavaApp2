package com.java.app2.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import com.java.app2.exception.EkartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    private Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception) {
        ErrorInfo error = new ErrorInfo();
        error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EkartException.class)
    public ResponseEntity<ErrorInfo>  ekartExceptionHandler(EkartException exception) {
        ErrorInfo error = new ErrorInfo();
        error.setErrorMessage(environment.getProperty(exception.getMessage()));
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorInfo> exceptonHandler(Exception exception) {
        ErrorInfo error = new ErrorInfo();
        String errorMsg = "";
        if(exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e1 = (MethodArgumentNotValidException) exception;
            errorMsg = e1.getBindingResult().getAllErrors().stream().map(meep -> meep.getDefaultMessage()).collect(Collectors.joining(", "));
        } else {
            ConstraintViolationException e1 = (ConstraintViolationException) exception;
            errorMsg = e1.getConstraintViolations().stream().map(meep -> meep.getMessage()).collect(Collectors.joining(", "));
        }

        error.setErrorMessage(errorMsg);
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
