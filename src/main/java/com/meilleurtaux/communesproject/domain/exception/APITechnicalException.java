package com.meilleurtaux.communesproject.domain.exception;

public class APITechnicalException extends RuntimeException {

    private final String errorCode;

    public APITechnicalException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
