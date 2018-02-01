package com.ntq.javateam.cms.backend.domain.user;

import com.ntq.javateam.cms.backend.domain.core.DomainService;
import com.ntq.javateam.cms.backend.web.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends DomainService {
    @Autowired
    IUserDAO userDAO;

    public List<UserResponse> getAllUsers() {
        List<User> users = userDAO.findAll();
        return users.stream().map(user -> new UserResponse(user)).collect(Collectors.toList());
    }
}
