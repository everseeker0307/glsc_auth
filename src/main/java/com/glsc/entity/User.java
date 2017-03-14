package com.glsc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/13.
 */
public class User implements Serializable {
    private long id;
    private String name;      //用户名
    private String password;            //密码
    private Set<Role> roles;          //角色
    private Set<Privilege> privileges;     //权限

    public User() {}

    public User(String username) {
        this(username, "");
    }

    public User(String name, String password) {
        this(name, password, null, null);
    }

    public User(String name, String password, Set<Role> roles, Set<Privilege> privileges) {
        this.name= name;
        this.password = password;
        this.roles = roles;
        this.privileges = privileges;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Set<Privilege> getAllPrivileges() {
        Set<Privilege> set = new HashSet<>();
        for (Role role : roles)
            set.addAll(role.getPrivileges());
        set.addAll(privileges);
        return set;
    }
}
