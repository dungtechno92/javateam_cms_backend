package com.ntq.javateam.cms.backend.web.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @RequestMapping(value = "/home")
    public ModelAndView home() {
        System.out.println("1");
        return new ModelAndView("index.html");
    }
}
