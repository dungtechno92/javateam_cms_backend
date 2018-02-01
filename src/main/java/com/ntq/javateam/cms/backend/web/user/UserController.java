package com.ntq.javateam.cms.backend.web.user;

import com.ntq.javateam.cms.backend.domain.user.UserService;
import com.ntq.javateam.cms.backend.web.support.Response;
import com.ntq.javateam.cms.backend.web.support.ResponseSupport;
import com.ntq.javateam.cms.backend.web.support.RestApiV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@RestApiV1
@CrossOrigin
public class UserController implements ResponseSupport {

    @Autowired
    public UserService userService;

    @GetMapping(path = "/users")
    public Response getAllUser(HttpServletResponse response) {
        return ok(userService.getAllUsers(), response, HttpStatus.OK);
    }
}
