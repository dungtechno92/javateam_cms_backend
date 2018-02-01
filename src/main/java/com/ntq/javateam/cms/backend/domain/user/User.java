package com.ntq.javateam.cms.backend.domain.user;

import com.ntq.javateam.cms.backend.domain.core.Domain;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends Domain {
    @Column(unique = true)
    String userName;
    
    @NotBlank
    String password;
    
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
