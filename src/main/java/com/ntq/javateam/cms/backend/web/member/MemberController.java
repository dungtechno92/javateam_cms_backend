package com.ntq.javateam.cms.backend.web.member;

import com.ntq.javateam.cms.backend.domain.member.MemberService;
import com.ntq.javateam.cms.backend.web.support.Response;
import com.ntq.javateam.cms.backend.web.support.ResponseSupport;
import com.ntq.javateam.cms.backend.web.support.RestApiV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/members/{id}")
    public Response getOne(HttpServletResponse response, @PathVariable Long id ) {
        return ok(memberService.getOne(id), response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/members/{id}")
    public void delete(HttpServletResponse response, @PathVariable Long id ) {
        memberService.delete(id);
        deletedOk(response);
    }

    @PostMapping(path = "/members")
    public Response create(HttpServletResponse response, @RequestBody MemberRequest memberRequest) {
        return ok(memberService.create(memberRequest), response, HttpStatus.OK);
    }

    @PutMapping(path = "/members/{id}")
    public Response create(HttpServletResponse response, @RequestBody MemberRequest memberRequest, @PathVariable Long id) {
        return ok(memberService.update(memberRequest, id), response, HttpStatus.OK);
    }
}
