package com.github.RandyDpoe45.account_server.exceptions.exceptiontypes;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AccountServiceException extends RuntimeException {

    private String exceptionCode;

    public AccountServiceException(ExceptionCodesEnum exceptionCode) {
        super(exceptionCode.getDefaultMessage());
        this.exceptionCode = exceptionCode.getCode();
    }

    public AccountServiceException(ExceptionCodesEnum exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode.getCode();
    }

    public AccountServiceException(Throwable cause, ExceptionCodesEnum exceptionCode, String message) {
        super(message, cause);
        this.exceptionCode = exceptionCode.getCode();
    }
}
