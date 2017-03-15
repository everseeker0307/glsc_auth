package com.glsc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by everseeker on 2017/3/14.
 */
public interface UserRoleRepository {
    @Insert("insert into users_roles(user_name, role_name) values(#{userName}, #{roleName})")
    void save(@Param("userName") String userName, @Param("roleName") String roleName);

    @Select("select role_name from users_roles where user_name = #{userName}")
    Set<String> getRolesByUserName(@Param("userName") String userName);

    @Select("select user_name from users_roles where role_name = #{roleName}")
    Set<String> getUsersByRoleName(@Param("roleName") String roleName);
}
