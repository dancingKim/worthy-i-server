package com.back.worthyi.dao;

import com.back.worthyi.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    boolean existsByEid(String email);

    void save(UserDto userDto);

    UserDto findByEid(String email);
}
