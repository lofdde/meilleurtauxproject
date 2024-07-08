package com.meilleurtaux.communesproject.exposition.error;

import com.meilleurtaux.communesproject.domain.exception.APITechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.meilleurtaux.communesproject.exposition.error.ErrorMessagesConstants.*;

@RestControllerAdvice
public class ExceptionHandlingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleMissingParams(MissingServletRequestParameterException ex) {
        String error = ex.getParameterName() + " parameter is missing";
        APIError apiError = new APIError(BAD_REQUEST_TITLE, error);
        LOGGER.error("Error during api call : " + apiError);
        return apiError;
    }

    @ExceptionHandler(APITechnicalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIError handleApiTechnicalException(APITechnicalException ex) {
        APIError apiError = new APIError(INTERNAL_SERVER_ERROR_TITLE, ex.getMessage());
        LOGGER.error("Error from geo.gouv api : " + apiError);
        return apiError;
    }

}