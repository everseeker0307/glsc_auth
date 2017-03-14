package com.glsc.controller;

import com.glsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by everseeker on 2017/3/10.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
//    @PreAuthorize("authenticated and hasAnyAuthority('client_r', 'client_w')")
    @PreAuthorize("authenticated and denyAll()")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam(value="username") String username,
                           @RequestParam(value="password") String password) {
        userService.addUser(username, password);
        return "hello";
    }
}
