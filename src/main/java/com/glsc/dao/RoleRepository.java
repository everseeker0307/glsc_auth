package com.glsc.dao;

import com.glsc.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by everseeker on 2017/3/13.
 */
public interface RoleRepository {
    @Insert("insert into roles(name) values(#{name})")
    void addRole(Role role);

    @Select("select id from roles where name = #{name}")
    Role getIdByName(@Param("name") String name);
}
