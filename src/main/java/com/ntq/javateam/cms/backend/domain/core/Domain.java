package com.ntq.javateam.cms.backend.domain.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    protected String createdBy;

    protected String updatedBy;

    protected Date createdAt;

    protected Date updatedAt;

    protected long version;

    public Domain createdBy(String createdBy) {
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        return this;
    }

    public Domain updatedBy(String updatedBy) {
        this.updatedAt = new Date();
        this.updatedBy = updatedBy;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Domain and() {
        return this;
    }

    public Domain then() {
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
