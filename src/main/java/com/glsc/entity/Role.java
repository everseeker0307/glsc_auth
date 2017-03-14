package com.glsc.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by everseeker on 2017/3/13.
 */
public class Role implements Serializable {
    private long id;
    private String name;
    private Set<User> users;
    private Set<Privilege> privileges;

    public Role() {}

    public Role(String name) {
        this(name, null, null);
    }

    public Role(String rolename, Set<User> users, Set<Privilege> privileges) {
        this.name = rolename;
        this.users = users;
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

    public void setName(String rolename) {
        this.name = rolename;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }
}
