package com.ntq.javateam.cms.backend.web.support;

import com.ntq.javateam.cms.backend.domain.core.DomainException;
import com.ntq.javateam.cms.backend.infrastructure.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(DomainException.class)
    protected ResponseEntity<Object> handleInvalidRequest(DomainException e, ServletWebRequest request) {
        ErrorResponse error = new ErrorResponse(new Error(e.getMessage(), e.getCode(), e.getConstraintViolations()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOG.error(JsonUtils.serialize(error), e);
        return handleExceptionInternal(e, error, headers, e.getStatus(), request);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleUncaught(Exception e, ServletWebRequest request) {
        ErrorResponse error = new ErrorResponse(new Error(e.getMessage(), 500, null));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LOG.error(JsonUtils.serialize(error), e);
        return handleExceptionInternal(e, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
