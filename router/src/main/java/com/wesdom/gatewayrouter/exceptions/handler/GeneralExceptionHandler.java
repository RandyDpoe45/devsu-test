/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesdom.gatewayrouter.exceptions.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wesdom.gatewayrouter.dtos.exception.ExceptionResponseDto;
import com.wesdom.gatewayrouter.exceptions.exceptiontypes.ExceptionCodesEnum;
import com.wesdom.gatewayrouter.exceptions.exceptiontypes.GatewayRouterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author randy
 */
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponseDto handlerGeneralException(GatewayRouterException exception) {
        return new ExceptionResponseDto(exception.getMessage(), exception.getExceptionCode());
    }

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponseDto handlerJsonProcessingException(JsonProcessingException exception) {
        exception.printStackTrace();
        return new ExceptionResponseDto("Json mal formado", ExceptionCodesEnum.UNPARSEABLE_JSON.getCode());
    }

    @ExceptionHandler
    @ResponseBody
    public ExceptionResponseDto HandlerException(Exception exception) {
        exception.printStackTrace();
        return new ExceptionResponseDto("Error inesperado", ExceptionCodesEnum.UNEXPECTED_ERROR.getCode());
    }

}
