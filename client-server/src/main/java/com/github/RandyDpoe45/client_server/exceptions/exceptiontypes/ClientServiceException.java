package com.github.RandyDpoe45.client_server.exceptions.exceptiontypes;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ClientServiceException extends RuntimeException {

    private String exceptionCode;

    public ClientServiceException(ExceptionCodesEnum exceptionCode) {
        super(exceptionCode.getDefaultMessage());
        this.exceptionCode = exceptionCode.getCode();
    }

    public ClientServiceException(ExceptionCodesEnum exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode.getCode();
    }

    public ClientServiceException(Throwable cause, ExceptionCodesEnum exceptionCode, String message) {
        super(message, cause);
        this.exceptionCode = exceptionCode.getCode();
    }
}
