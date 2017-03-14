package com.glsc.dao;

import com.glsc.entity.Privilege;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by everseeker on 2017/3/13.
 */
public interface PrivilegeRepository {
    @Insert("insert into privileges(name) values(#{name})")
    void addPrivilege(Privilege privilege);

    @Select("select id from privileges where name = #{name}")
    Privilege getIdByName(@Param("name") String name);

    @Select("select role_name from roles_privileges where privilege_name = #{privilege_name}")
    Set<String> getRolesByName(@Param("privilege_name") String privilege_name);

    @Select("select user_name from users_privileges where privilege_name = #{privilege_name}")
    Set<String> getUsersByName(@Param("privilege_name") String privilege_name);
}
