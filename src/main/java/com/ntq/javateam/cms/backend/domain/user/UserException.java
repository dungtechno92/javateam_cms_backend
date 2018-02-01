package com.ntq.javateam.cms.backend.domain.user;

import com.ntq.javateam.cms.backend.domain.core.DomainException;

public class UserException extends DomainException {

    public UserException(int errorCode, String message) {
        super(UserException.DomainType.USER, errorCode, message);
    }
    
    public UserException(int errorCode, Throwable throwable) {
        super(DomainType.USER, errorCode, throwable);
    }
}
