package com.opsyx.openapi.sample.controllers;

import com.opsyx.openapi.sample.exceptions.InternalException;
import com.opsyx.openapi.sample.exceptions.NotFoundException;
import com.opsyx.openapi.sample.exceptions.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException() {

    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalException.class)
    public void handleInternalException() {}

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public void handleUnauthorized(HttpServletRequest req) {
      log.error("Unauthorized exception on {}", req.getPathInfo());
    }
}
