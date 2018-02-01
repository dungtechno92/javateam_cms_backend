package com.ntq.javateam.cms.backend.domain.member;

import com.ntq.javateam.cms.backend.domain.core.DomainDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.List;

@Component
public class MemberDAO extends DomainDAO implements IMemberDAO {
    private static final Logger LOG = LoggerFactory.getLogger(MemberDAO.class);

    public MemberDAO(EntityManagerFactory factory) {
        super(factory);
    }

    @Override
    public List<Member> findAll() {
        Session session = hibernateFactory.openSession();
        List<Member> members;
        try {
            Criteria criteria = session.createCriteria(Member.class);
            members = criteria.list();
        } finally {
            session.close();
        }

        return members == null ? Collections.EMPTY_LIST : members;
    }

    @Override
    public Member create(Member member) {
        Session session = hibernateFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return member;
    }
}
