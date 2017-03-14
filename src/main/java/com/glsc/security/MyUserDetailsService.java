package com.glsc.security;

import com.glsc.entity.User;
import com.glsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/14.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(userName);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    userName,
                    user.getPassword(),
                    getGrantedAuthorities(userService.getAllPrivilegesByUsername(userName)));
        }
        throw new UsernameNotFoundException(
                "User '" + userName + "' not found!");
    }

    private Set<GrantedAuthority> getGrantedAuthorities(Set<String> privileges) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (String privilege : privileges)
            authorities.add(new SimpleGrantedAuthority(privilege));
        return authorities;
    }
}
