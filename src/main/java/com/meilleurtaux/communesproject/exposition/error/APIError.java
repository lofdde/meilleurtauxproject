package com.meilleurtaux.communesproject.exposition.error;

public class APIError {

    private final String error;

    private final String detail;

    public APIError(String error, String detail) {
        this.error = error;
        this.detail = detail;
    }

    public String getError() {
        return error;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "title='" + error + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
