/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesdom.gatewayrouter.exceptions.exceptiontypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 *
 * @author randy
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class GatewayRouterException extends RuntimeException {
    
    private String exceptionCode;

    public GatewayRouterException(ExceptionCodesEnum exceptionCode) {
        super(exceptionCode.getDefaultMessage());
        this.exceptionCode = exceptionCode.getCode();
    }

    public GatewayRouterException(ExceptionCodesEnum exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode.getCode();
    }

    public GatewayRouterException(Throwable cause, ExceptionCodesEnum exceptionCode, String message) {
        super(message, cause);
        this.exceptionCode = exceptionCode.getCode();
    }

}
