package org.maxwell.wrongcase.apidesign_22.apiresponse;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class APIException extends RuntimeException {

    private final int errorCode;

    private final String errorMessage;

    public APIException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public APIException(int errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}