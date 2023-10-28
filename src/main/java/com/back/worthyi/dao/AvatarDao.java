package com.back.worthyi.dao;

import com.back.worthyi.dto.AvatarDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AvatarDao {
    void save(AvatarDto avatar);

    List<AvatarDto> findByUserId(String userId);
}
