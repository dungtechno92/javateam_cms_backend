package com.ntq.javateam.cms.backend.domain.member;

import com.ntq.javateam.cms.backend.domain.core.DomainException;

public class MemberException  extends DomainException {
    public static final int INVALID_MEMBER = 1;

    public static final int SAVE_MEMBER_FAILURE = 2;

    public static final int GET_ALL_MEMBER_FAILURE = 3;

    public static final int INVALID_MEMBER_ID = 4;

    public static final int MEMBER_NOT_EXISTING = 5;

    public MemberException(int errorCode, String message) {
        super(DomainType.MEMBER, errorCode, message);
    }

    public MemberException(int errorCode, Throwable throwable) {
        super(DomainType.MEMBER, errorCode, throwable);
    }
}