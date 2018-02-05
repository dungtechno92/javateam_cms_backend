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
@Transactional
public class MemberService extends DomainService {

    @Autowired
    private Validator validator;

    @Autowired
    IMemberDAO memberDAO;

    public List<MemberResponse> getAll() {
        List<Member> members = memberDAO.findAll();
        return members.stream().map(member -> new MemberResponse(member)).collect(Collectors.toList());
    }

    public MemberResponse getOne(Long id) {
        Member member = memberDAO.findOne(id);
        ensureMemberExisting(member, id);
        return new MemberResponse(member);
    }

    public MemberResponse create(MemberRequest memberRequest) {
        Member member = new Member(memberRequest);
        member.createdBy("system");
        validateMember(member);
        Member memberSaved = memberDAO.create(member);
        return new MemberResponse(memberSaved);
    }

    public MemberResponse update(MemberRequest memberRequest, Long id) {
        Member memberInDb = memberDAO.findOne(id);
        ensureMemberExisting(memberInDb, id);

        memberInDb.setPhoneNumber(memberRequest.getPhoneNumber());
        memberInDb.setName(memberRequest.getName());
        memberInDb.setEmail(memberRequest.getEmail());
        memberInDb.setJoinDate(memberRequest.getJoinDate());
        memberInDb.setLeftDate(memberRequest.getLeftDate());
        memberInDb.updatedBy("system");
        validateMember(memberInDb);
        Member memberSaved = memberDAO.update(memberInDb);
        return new MemberResponse(memberSaved);
    }

    public void delete(Long id) {
        Member member = memberDAO.findOne(id);
        ensureMemberExisting(member, id);
        memberDAO.delete(id);
    }

    private void validateMember(Member member) {
        Set<ConstraintViolation<Domain>> constraintViolations = validator.validate(member);
        if (!constraintViolations.isEmpty()) {
            throw new MemberException(MemberException.INVALID_MEMBER, "Invalid member.").setConstraintViolations(constraintViolations);
        }
    }

    private void ensureMemberExisting(Member member, Long id) {
        if (member == null) {
            throw new MemberException(MemberException.MEMBER_NOT_EXISTING, String.format("Member with id %s not existing in database.", id));
        }
    }
}
