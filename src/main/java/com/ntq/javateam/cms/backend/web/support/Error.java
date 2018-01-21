package com.ntq.javateam.cms.backend.web.support;

import com.ntq.javateam.cms.backend.domain.core.Domain;

import javax.validation.ConstraintViolation;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Error {

    private final String message;

    private final int code;

    private final Date timestamp = new Date();

    private List<ErrorDetail> details;

    public Error(String message, int code, Set<ConstraintViolation<Domain>> constraintViolations) {
        this.message = message;
        this.code = code;
        if (constraintViolations != null) {
            this.details = constraintViolations.stream().map(v -> {
                String resource = v.getRootBeanClass().getSimpleName();
                String field = v.getPropertyPath().toString();
                String violation = field + " is " + v.getInvalidValue() + " but " + v.getMessage();
                return new ErrorDetail(resource, field, violation);
            }).collect(Collectors.toList());
        }
    }


    public static class ErrorDetail {

        private final String resource;

        private final String field;

        private final String violation;

        public ErrorDetail(String resource, String field, String violation) {
            this.resource = resource;
            this.field = field;
            this.violation = violation;
        }

        public String getResource() {
            return resource;
        }

        public String getField() {
            return field;
        }

        public String getViolation() {
            return violation;
        }

    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }

}
