package com.ntq.javateam.cms.backend.domain.member;

import com.ntq.javateam.cms.backend.domain.core.DomainException;

public class MemberException  extends DomainException {
    public static final int INVALID_MEMBER = 1;

    public MemberException(int errorCode, String message) {
        super(DomainType.MEMBER, errorCode, message);
    }

    public MemberException(int errorCode, Throwable throwable) {
        super(DomainType.MEMBER, errorCode, throwable);
    }
}