package com.ntq.javateam.cms.backend.web.support;

public class SuccessResponse extends Response {

    private final Object data;

    public SuccessResponse() {
        this(null);
    }

    public SuccessResponse(Object data) {
        this.data = data;
    }

    public SuccessResponse(Object data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

}
