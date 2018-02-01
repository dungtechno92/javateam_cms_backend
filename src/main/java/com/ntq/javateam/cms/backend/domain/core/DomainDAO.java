package com.ntq.javateam.cms.backend.domain.core;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManagerFactory;

public abstract class DomainDAO implements IDomainDAO {
    protected SessionFactory hibernateFactory;

    public DomainDAO(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }
}
