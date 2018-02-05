package com.ntq.javateam.cms.backend.domain.member;

import java.util.List;

public interface IMemberDAO {
    public List<Member> findAll();
    public Member findOne(Long id);
    public Member create(Member member);
    public Member update(Member member);
    public void delete(Long id);
}
