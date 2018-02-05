package com.ntq.javateam.cms.backend.domain.member;

import com.ntq.javateam.cms.backend.domain.core.Domain;
import com.ntq.javateam.cms.backend.web.member.MemberRequest;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Member extends Domain {
    @NotBlank
    String name;

    @NotBlank
    String email;

    String phoneNumber;

    @NotNull
    Date joinDate;

    Date leftDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
    }

    public Member() {
    }

    public Member(MemberRequest memberRequest) {
        this.email = memberRequest.getEmail();
        this.phoneNumber = memberRequest.getPhoneNumber();
        this.name = memberRequest.getName();
        this.joinDate = memberRequest.getJoinDate();
        this.leftDate = memberRequest.getLeftDate();
    }
}
