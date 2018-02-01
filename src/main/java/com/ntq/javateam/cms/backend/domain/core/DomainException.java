package com.ntq.javateam.cms.backend.domain.core;

import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = -4209559241545600860L;

    public static final int NOT_FOUND = 1;
    public static final int ALREADY_EXISTS = 2;
    private static final int UNIT_SIZE = 100;
    public static final int UNKNOWN_ERROR = 9;

    private DomainType domain;

    private int errorCode;

    private String customMessage;

    Set<ConstraintViolation<Domain>> constraintViolations;

    protected HttpStatus status = HttpStatus.BAD_REQUEST;

    public DomainException() {
    }

    public DomainException(int errorCode) {
        this(DomainType.GENERAL, errorCode, null, null);
    }

    public DomainException(DomainType domain, int errorCode) {
        this(domain, errorCode, null, null);
    }

    public DomainException(DomainType domain, int errorCode, Throwable e) {
        this(domain, errorCode, null, e);
    }

    public DomainException(DomainType domain, int errorCode, String message) {
        this(domain, errorCode, message, null);
    }

    public DomainException(DomainType domain, int errorCode, String message, Throwable e) {
        super(message, e);
        this.domain = domain;
        this.errorCode = errorCode;
    }

    public int getCode() {
        return calculateCode(domain.getDomainCode(), errorCode);
    }

    public static int calculateCode(int domainCode, int errorCode) {
        return domainCode * UNIT_SIZE + errorCode;
    }

    public enum DomainType {

        GENERAL(1),

        USER(2),

        MEMBER(3);

        private int domainCode;

        DomainType(int domainCode) {
            this.domainCode = domainCode;
        }

        public int getDomainCode() {
            return domainCode;
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public DomainException status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public Set<ConstraintViolation<Domain>> getConstraintViolations() {
        return constraintViolations;
    }

    public DomainException setConstraintViolations(Set<ConstraintViolation<Domain>> constraintViolations) {
        this.constraintViolations = constraintViolations;
        return this;
    }

    public DomainException customMessage(String msg) {
        this.customMessage = msg;
        return this;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
