package com.glsc.controller;

import com.glsc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/10.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @PreAuthorize("authenticated and hasAnyAuthority('client_r', 'client_w')")
    public String hello(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Set<String> privileges = new HashSet<>();
        for (GrantedAuthority grantedAuthority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            privileges.add(grantedAuthority.getAuthority());
        }
        model.addAttribute("username", username);
        model.addAttribute("privileges", privileges);
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
        return "redirect:/hello";
    }
}
