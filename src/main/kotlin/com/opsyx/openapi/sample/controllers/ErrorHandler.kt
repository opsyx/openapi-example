package com.opsyx.openapi.sample.controllers

import com.opsyx.openapi.sample.exceptions.InternalException
import com.opsyx.openapi.sample.exceptions.NotFoundException
import com.opsyx.openapi.sample.exceptions.UnauthorizedException
import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
@Slf4j
class ErrorHandler {

    private val log = KotlinLogging.logger {}

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException() {
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalException::class)
    fun handleInternalException() {
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException::class)
    fun handleUnauthorized(req: HttpServletRequest) {
        log.error("Unauthorized exception on {}", req.pathInfo)
    }

}