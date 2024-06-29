/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesdom.gatewayrouter.exceptions.exceptiontypes;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author randy
 */
@Getter
@AllArgsConstructor
public enum ExceptionCodesEnum {


    UNEXPECTED_ERROR("001"),
    UNPARSEABLE_JSON("004");

    private final String code;
    private String defaultMessage;

    ExceptionCodesEnum(String code) {
        this.code = code;
    }

}
