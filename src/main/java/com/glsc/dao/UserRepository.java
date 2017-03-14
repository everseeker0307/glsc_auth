package com.glsc.dao;

import com.glsc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * Created by everseeker on 2017/3/13.
 */
public interface UserRepository {
    @Insert("insert into users(name, password) values(#{name}, #{password})")
    void save(User user);

    @Select("select * from users where name = #{name}")
    User getUserByName(@Param("name") String name);

    @Select("select role_name from users_roles where user_name = #{userName}")
    Set<String> getRolesByName(@Param("userName") String userName);

    @Select("select privilege_name from users_privileges where user_name = #{userName}")
    Set<String> getPrivilegesByName(@Param("userName") String userName);
}
