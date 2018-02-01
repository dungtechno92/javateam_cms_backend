package com.ntq.javateam.cms.backend.domain.user;

import com.ntq.javateam.cms.backend.domain.core.DomainDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class UserDAO extends DomainDAO implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;
}
