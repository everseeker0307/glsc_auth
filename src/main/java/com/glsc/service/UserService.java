package com.glsc.service;

import com.glsc.dao.RoleRepository;
import com.glsc.dao.UserPrivilegeRepository;
import com.glsc.dao.UserRepository;
import com.glsc.dao.UserRoleRepository;
import com.glsc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/14.
 */
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserPrivilegeRepository userPrivilegeRepository;

    public void addUser(String username, String password) {
        userRepository.save(new User(username, new BCryptPasswordEncoder().encode(password)));
    }

    public User getUserByUserName(String userName) {
        return userRepository.getUserByName(userName);
    }

    @Transactional
    public void addUserAndRolesAndPrivileges(String userName, String password, Set<String> roles, Set<String> privileges) {
        userRepository.save(new User(userName, new BCryptPasswordEncoder().encode(password)));
        for (String roleName : roles)
            userRoleRepository.save(userName, roleName);
        for (String privilegeName : privileges)
            userPrivilegeRepository.save(userName, privilegeName);
    }

    @Transactional
    public Set<String> getAllPrivilegesByUsername(String userName) {
        Set<String> set = new HashSet<>();
        set.addAll(userRepository.getPrivilegesByName(userName));
        for (String roleName : userRepository.getRolesByName(userName))
            set.addAll(roleRepository.getPrivilegesByName(roleName));
        return set;
    }
}
