package com.glsc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by everseeker on 2017/3/14.
 */
public interface UserRoleRepository {
    @Insert("insert into users_roles(user_name, role_name) values(#{userName}, #{roleName})")
    void save(@Param("userName") String userName, @Param("roleName") String roleName);
}
