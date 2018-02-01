package com.ntq.javateam.cms.backend.web.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ntq.javateam.cms.backend.domain.user.User;

public class UserResponse {
    @JsonProperty(value = "userName")
    String userName;

    @JsonProperty(value = "password")
    String password;

    public UserResponse(User user) {
        if (user == null) {
            return;
        }
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
