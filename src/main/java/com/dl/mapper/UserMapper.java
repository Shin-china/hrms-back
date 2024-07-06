package com.dl.mapper;

import com.dl.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {
    //Insert User
    @Insert("insert into user(username,password,create_time,update_time)"+
    " values(#{username},#{password},now(),now())")
    public void insert(String username, String password);

    //Find
    @Select("select * from user where username=#{username}")
    public User findByUserName(String username);
}
