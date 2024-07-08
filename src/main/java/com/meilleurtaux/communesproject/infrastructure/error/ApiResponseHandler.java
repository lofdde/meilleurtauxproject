package com.meilleurtaux.communesproject.infrastructure.error;

import com.meilleurtaux.communesproject.domain.exception.APITechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class ApiResponseHandler implements ResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiResponseHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !(HttpStatus.OK.equals(response.getStatusCode()) || HttpStatus.CREATED.equals(response.getStatusCode()));
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        LOGGER.error(String.format("Error during the call of the api. Status code : %s with body %s", response.getStatusCode().value(), new String(response.getBody().readAllBytes())));
        throw new APITechnicalException("Technical error during the call of the api", "ERROR_TECH");
    }

}
