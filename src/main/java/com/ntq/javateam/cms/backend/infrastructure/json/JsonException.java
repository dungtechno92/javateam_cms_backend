package com.ntq.javateam.cms.backend.infrastructure.json;

import com.ntq.javateam.cms.backend.domain.core.DomainException;

public class JsonException extends DomainException {
    
    public static final int JSON_PARSING_ERROR = 100;

    private static final long serialVersionUID = 1008117256405035757L;

    public JsonException(int errorCode, String message) {
        super(DomainType.GENERAL, errorCode, message);
    }

    public JsonException(int errorCode, Throwable throwable) {
        super(DomainType.GENERAL, errorCode, throwable);
    }

}
