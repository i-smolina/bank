package com.example.bank.advice;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({CallNotPermittedException.class, FeignException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void handleCallNotPermitted() {
    }
}


