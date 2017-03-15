package com.glsc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by everseeker on 2017/3/14.
 */
public interface UserPrivilegeRepository {
    @Insert("insert into users_privileges(user_name, privilege_name) values(#{userName}, #{privilegeName})")
    void save(@Param("userName") String userName, @Param("privilegeName") String privilegeName);

    @Select("select privilege_name from users_privileges where user_name = #{userName}")
    Set<String> getPrivilegesByUserName(@Param("userName") String userName);
}
