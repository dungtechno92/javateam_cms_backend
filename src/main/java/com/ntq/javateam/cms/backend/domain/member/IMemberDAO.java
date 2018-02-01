package com.ntq.javateam.cms.backend.domain.member;

import java.util.List;

public interface IMemberDAO {
    public List<Member> findAll();
    public Member create(Member member);
}
