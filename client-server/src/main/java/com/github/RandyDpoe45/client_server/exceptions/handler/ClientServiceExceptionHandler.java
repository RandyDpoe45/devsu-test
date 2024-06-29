/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.RandyDpoe45.client_server.exceptions.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.RandyDpoe45.client_server.exceptions.dtos.ExceptionResponse;
import com.github.RandyDpoe45.client_server.exceptions.exceptiontypes.ClientServiceException;
import com.github.RandyDpoe45.client_server.exceptions.exceptiontypes.ExceptionCodesEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author randy
 */
@RestControllerAdvice
public class ClientServiceExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponse handlerGeneralException(ClientServiceException exception) {
        return ExceptionResponse.builder()
                .exceptionCode(exception.getExceptionCode())
                .response(exception.getMessage())
                .build();
    }

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponse handlerJsonProcessingException(JsonProcessingException exception) {
        return new ExceptionResponse(
                exception.getMessage(),
                ExceptionCodesEnum.UNPARSEABLE_JSON.getCode()
        );
    }

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponse HandlerException(Exception exception) {
        return new ExceptionResponse(exception.getMessage(), ExceptionCodesEnum.UNEXPECTED_ERROR.getCode());
    }

}
