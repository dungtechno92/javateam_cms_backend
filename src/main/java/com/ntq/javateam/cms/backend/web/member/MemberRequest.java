package com.ntq.javateam.cms.backend.web.member;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MemberRequest {
    @JsonProperty(value = "name")
    String name;

    @JsonProperty(value = "email")
    String email;

    @JsonProperty(value = "phoneNumber")
    String phoneNumber;

    @JsonProperty(value = "joinDate")
    Long joinDate;

    @JsonProperty(value = "leftDate")
    Long leftDate;

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
        if (joinDate != null) {
            return new Date(joinDate);
        }
        return null;
    }

    public void setJoinDate(Long joinDate) {
        this.joinDate = joinDate;
    }

    public Date getLeftDate() {
        if (leftDate != null) {
            return new Date(leftDate);
        }
        return null;
    }

    public void setLeftDate(Long leftDate) {
        this.leftDate = leftDate;
    }
}
