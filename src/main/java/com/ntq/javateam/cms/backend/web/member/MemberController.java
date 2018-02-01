package com.ntq.javateam.cms.backend.web.member;

import com.ntq.javateam.cms.backend.domain.member.MemberService;
import com.ntq.javateam.cms.backend.web.support.Response;
import com.ntq.javateam.cms.backend.web.support.ResponseSupport;
import com.ntq.javateam.cms.backend.web.support.RestApiV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

@RestApiV1
@CrossOrigin
public class MemberController implements ResponseSupport {

    @Autowired
    public MemberService memberService;

    @GetMapping(path = "/members")
    public Response getAll(HttpServletResponse response) {
        return ok(memberService.getAll(), response, HttpStatus.OK);
    }

    @PostMapping(path = "/members")
    public Response create(@RequestBody MemberRequest memberRequest, HttpServletResponse response) {
        return ok(memberService.create(memberRequest), response, HttpStatus.OK);
    }
}
