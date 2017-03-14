package com.glsc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @Test
    @Rollback(false)
    public void addUserAndRolesAndPrivilegesTest() {
        String username = "xyz";
        String password = "123";
        Set<String> roles = new HashSet<>();
        roles.add("securities analyst");
        userService.addUserAndRolesAndPrivileges(username, password, roles, null);
    }
}
