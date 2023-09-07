package com.ingemark.business.api.rest.endpoint;

import com.ingemark.business.service.ServiceGeneralException;
import com.ingemark.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(ServiceGeneralException.class)
    public ResponseEntity<ResponseWrapper<String>> handleServiceGeneralException(Exception ex) {

        LOGGER.error(ex.getMessage(), ex);

        ResponseWrapper<String> exceptionResponseWrapper = new ResponseWrapper<>();
        exceptionResponseWrapper.setMessage("Service failure.");
        exceptionResponseWrapper.setData(ex.getMessage());

        return new ResponseEntity<>(exceptionResponseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<String>> handleUnhandledException(Exception ex) {

        LOGGER.error(ex.getMessage(), ex);

        ResponseWrapper<String> exceptionResponseWrapper = new ResponseWrapper<>();
        exceptionResponseWrapper.setMessage("Unexpected failure.");
        exceptionResponseWrapper.setData(ex.getMessage());

        return new ResponseEntity<>(exceptionResponseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
