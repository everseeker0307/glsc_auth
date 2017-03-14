package com.glsc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by everseeker on 2017/3/14.
 */
public interface UserPrivilegeRepository {
    @Insert("insert into users_privileges(user_name, privilege_name) values(#{userName}, #{privilegeName})")
    void save(@Param("userName") String userName, @Param("privilegeName") String privilegeName);
}
