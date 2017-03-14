package com.glsc.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/13.
 */
public class Privilege implements Serializable {
    private long id;
    private String name;
    private Set<Role> roles;
    private Set<User> users;

    public Privilege() {}

    public Privilege(String name) {
        this(name, null, null);
    }

    public Privilege(String name, Set<Role> roles, Set<User> users) {
        this.name = name;
        this.roles = roles;
        this.users = users;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
