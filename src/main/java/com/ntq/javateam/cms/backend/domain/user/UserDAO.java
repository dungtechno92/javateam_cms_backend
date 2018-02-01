package com.ntq.javateam.cms.backend.domain.user;

import com.ntq.javateam.cms.backend.domain.core.DomainDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.List;

@Component
public class UserDAO extends DomainDAO implements IUserDAO {

    @Autowired
    public UserDAO(EntityManagerFactory factory) {
        super(factory);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        Session session = hibernateFactory.openSession();
        List<User> users;
        try {
            Criteria criteria = session.createCriteria(User.class);
            users = criteria.list();
        } finally {
            session.close();
        }

        return users == null ? Collections.EMPTY_LIST : users;
    }
}
