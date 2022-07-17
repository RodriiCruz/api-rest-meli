package com.meli.examen.exception.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.meli.examen.exception.InvalidDnaException;
import com.meli.examen.exception.dto.ErrorDto;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { InvalidDnaException.class })
    protected ResponseEntity<Object> generalException(Exception ex, WebRequest request) {
        ErrorDto error = ErrorDto.builder().error(true).message(ex.getMessage()).code(422).build();
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
