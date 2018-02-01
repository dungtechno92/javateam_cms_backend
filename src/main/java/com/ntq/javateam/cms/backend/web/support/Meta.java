package com.ntq.javateam.cms.backend.web.support;

public class Meta {

    private String href;

    private String next;

    private String prev;

    private int total;

    private int page;

    private int pageSize;

    public Meta href(String href) {
        this.href = href;
        return this;
    }

    public Meta next(String next) {
        this.next = next;
        return this;
    }

    public Meta prev(String prev) {
        this.prev = prev;
        return this;
    }

    public Meta total(int total) {
        this.total = total;
        return this;
    }

    public Meta page(int page) {
        this.page = page;
        return this;
    }

    public Meta pageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getHref() {
        return href;
    }

    public String getNext() {
        return next;
    }

    public String getPrev() {
        return prev;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

}
