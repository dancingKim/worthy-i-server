package com.back.worthyi.service;

import com.back.worthyi.dao.AvatarDao;
import com.back.worthyi.dto.AvatarDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AvatarServiceImpl implements AvatarService{
    private final AvatarDao avatarDao;

    @Autowired
    public AvatarServiceImpl(AvatarDao avatarDao) {
        this.avatarDao = avatarDao;
    }

    @Override
    public AvatarDto createAvatar(AvatarDto avatar) {
        avatarDao.save(avatar);
        List<AvatarDto> avatars = avatarDao.findByUserId(avatar.getUserId());
        return null;
    }

    @Override
    public AvatarDto getAvatar(String userId) {
        return null;
    }
}
