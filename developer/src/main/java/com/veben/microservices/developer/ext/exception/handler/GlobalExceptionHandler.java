package com.veben.microservices.developer.ext.exception.handler;

import com.veben.microservices.developer.ext.exception.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEV_DATABASE_ERROR_MESSAGE = "Developer Database (PostgreSQL) is down!";
    private static final String DEV_INFO_DATABASE_ERROR_MESSAGE = "Developer Information Database (MongoDB) is down!";
    private static final String DEV_INFO_MS_ERROR_MESSAGE = "MS Developer Information is down!";
    private static final String UNHANDLED_ERROR_MESSAGE = "Unhandled error!";

    @ExceptionHandler(DataAccessResourceFailureException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorDto dataAccessExceptionHandler(DataAccessResourceFailureException e) {
        log.warn(DEV_DATABASE_ERROR_MESSAGE + " - " + e.getMessage());
        return new ErrorDto(HttpStatus.SERVICE_UNAVAILABLE.value(), DEV_DATABASE_ERROR_MESSAGE);
    }

    @ExceptionHandler(ResourceAccessException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorDto resourceAccessExceptionHandler(ResourceAccessException e) {
        log.warn(DEV_INFO_MS_ERROR_MESSAGE + " - " + e.getMessage());
        return new ErrorDto(HttpStatus.SERVICE_UNAVAILABLE.value(), DEV_INFO_MS_ERROR_MESSAGE);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorDto httpServerExceptionHandler(HttpServerErrorException e) {
        log.warn(DEV_INFO_DATABASE_ERROR_MESSAGE + " - " + e.getMessage());
        return new ErrorDto(HttpStatus.SERVICE_UNAVAILABLE.value(), DEV_INFO_DATABASE_ERROR_MESSAGE);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorDto httpServerExceptionHandler(Exception e) {
        log.warn(UNHANDLED_ERROR_MESSAGE + " - " + e.getMessage());
        return new ErrorDto(HttpStatus.SERVICE_UNAVAILABLE.value(), UNHANDLED_ERROR_MESSAGE);
    }
}
