package com.ntq.javateam.cms.backend.web.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ntq.javateam.cms.backend.domain.member.Member;

public class MemberResponse {
    @JsonProperty(value = "id")
    long id;

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

    public MemberResponse(Member member) {
        if (member == null) {
            return;
        }

        id = member.getId();
        name = member.getName();
        email = member.getEmail();
        phoneNumber = member.getPhoneNumber();
        if (member.getJoinDate() != null) {
            joinDate = member.getJoinDate().getTime();
        }
        if (member.getLeftDate() != null) {
            leftDate = member.getLeftDate().getTime();
        }
    }
}
