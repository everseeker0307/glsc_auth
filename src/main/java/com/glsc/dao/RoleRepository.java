package com.glsc.dao;

import com.glsc.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by everseeker on 2017/3/13.
 */
public interface RoleRepository {
    @Insert("insert into roles(name) values(#{name})")
    void addRole(Role role);

    @Select("select id from roles where name = #{name}")
    Role getIdByName(@Param("name") String name);

    @Select("select user_name from users_roles where role_name = #{roleName}")
    Set<String> getUsersByName(@Param("roleName") String roleName);

    @Select("select privilege_name from roles_privileges where role_name = #{roleName}")
    Set<String> getPrivilegesByName(@Param("roleName") String roleName);
}
