package com.back.worthyi.service;

import com.back.worthyi.dto.AvatarDto;
import org.springframework.stereotype.Service;

@Service
public interface AvatarService {
    AvatarDto createAvatar(AvatarDto avatar);
    AvatarDto getAvatar(String userId);
}
