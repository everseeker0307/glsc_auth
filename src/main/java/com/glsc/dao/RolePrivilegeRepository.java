package com.glsc.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by everseeker on 2017/3/15.
 */
public interface RolePrivilegeRepository {
    @Select("select privilege_name from roles_privileges where role_name = #{roleName}")
    Set<String> getPrivilegesByRoleName(@Param("roleName") String roleName);
}
