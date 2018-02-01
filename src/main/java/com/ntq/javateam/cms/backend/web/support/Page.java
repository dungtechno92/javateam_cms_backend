package com.ntq.javateam.cms.backend.web.support;

public class Page {

    private Iterable<?> items;

    public Page(Iterable<?> items) {
        this.items = items;
    }

    public Iterable<?> getItems() {
        return items;
    }

}
