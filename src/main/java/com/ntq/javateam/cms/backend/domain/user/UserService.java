package com.ntq.javateam.cms.backend.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserDAO userDAO;
}
