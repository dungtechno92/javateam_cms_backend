package com.ntq.javateam.cms.backend.web.support;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public interface ResponseSupport {

    default public SuccessResponse ok(Object data) {
        return new SuccessResponse(data);
    }

    default public SuccessResponse createdOk(Object data, HttpServletResponse response) {
        return ok(data, response, HttpStatus.CREATED);
    }

    default public SuccessResponse updatedOk(Object data, HttpServletResponse response) {
        return ok(data, response, HttpStatus.OK);
    }

    default public void deletedOk(HttpServletResponse response) {
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }

    default void noContent(HttpServletResponse response) {
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }

    default public SuccessResponse ok(Object data, HttpServletResponse response, HttpStatus status) {
        response.setStatus(status.value());
        return new SuccessResponse(data);
    }

    default public SuccessResponse page(Collection<?> items, Meta meta) {
        return new SuccessResponse(new Page(items), meta);
    }

    default public SuccessResponse page(Collection<?> items) {
        return new SuccessResponse(new Page(items), new Meta().page(0).pageSize(items.size()).total(items.size()));
    }

}
