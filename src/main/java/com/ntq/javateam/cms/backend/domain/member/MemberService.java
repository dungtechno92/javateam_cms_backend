package com.ntq.javateam.cms.backend.domain.member;

import com.ntq.javateam.cms.backend.domain.core.Domain;
import com.ntq.javateam.cms.backend.domain.core.DomainService;
import com.ntq.javateam.cms.backend.web.member.MemberRequest;
import com.ntq.javateam.cms.backend.web.member.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberService extends DomainService {

    @Autowired
    private Validator validator;

    @Autowired
    IMemberDAO memberDAO;

    public List<MemberResponse> getAll() {
        List<Member> members = memberDAO.findAll();
        return members.stream().map(member -> new MemberResponse(member)).collect(Collectors.toList());
    }

    @Transactional
    public MemberResponse create(MemberRequest memberRequest) {
        Member member = formRequest(memberRequest);
        member.createdBy("system");
        validateMember(member);
        Member memberSaved = memberDAO.create(member);
        return new MemberResponse(memberSaved);
    }

    private void validateMember(Member member) {
        Set<ConstraintViolation<Domain>> constraintViolations = validator.validate(member);
        if (!constraintViolations.isEmpty()) {
            throw new MemberException(MemberException.INVALID_MEMBER, "Invalid member.").setConstraintViolations(constraintViolations);
        }
    }

    private Member formRequest(MemberRequest memberRequest) {
        Member member = new Member();
        member.setEmail(memberRequest.getEmail());
        member.setPhoneNumber(memberRequest.getPhoneNumber());
        member.setName(memberRequest.getName());
        member.setJoinDate(memberRequest.getJoinDate());
        member.setLeftDate(memberRequest.getLeftDate());

        return member;
    }
}
