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
        } catch (Exception e) {
            LOG.warn("Get all members encountered an error: ", e);
            throw e;
        } finally {
            session.close();
        }

        return members == null ? Collections.EMPTY_LIST : members;
    }

    @Override
    public Member findOne(Long id) {
        if (id == null || id <= 0) {
            throw new MemberException(MemberException.INVALID_MEMBER_ID, String.format("Member id % was invalid.", id));
        }

        Session session = hibernateFactory.openSession();
        Member member;
        try {
            member = session.get(Member.class, id);
        } catch (Exception e) {
            String errorMessage = String.format("Get a member with identify %s encountered an error: ", id);
            LOG.warn(errorMessage, e);
            throw e;
        } finally {
            session.close();
        }

        return member;
    }

    @Override
    public Member create(Member member) {
        Session session = hibernateFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOG.warn("Save a member encountered an error: ", e);
            throw e;
        } finally {
            session.close();
        }

        return member;
    }

    @Override
    public Member update(Member member) {
        Session session = hibernateFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOG.warn("Save a member encountered an error: ", e);
            throw e;
        } finally {
            session.close();
        }

        return member;
    }

    @Override
    public void delete(Long id) {
        Session session = hibernateFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Member member = session.get(Member.class, id);
            session.delete(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOG.warn("Delete a member with id  encountered an error: ", e);
            throw e;
        } finally {
            session.close();
        }
    }
}
