package com.back.worthyi.service;

import com.back.worthyi.dao.AvatarDao;
import com.back.worthyi.dto.AvatarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AvatarServiceImplTest {

    @Mock
    private AvatarDao avatarDao;

    @InjectMocks
    private AvatarServiceImpl avatarService;

    String testUserId;

    @BeforeEach
    void createTestUserId(){
        testUserId = UUID.randomUUID().toString().replace("-","");
    }

    @Test
    void TestCreateAvatar() {
        AvatarDto avatar = new AvatarDto().builder()
                .avatarNm("정호 아바타")
                .avatarImg("https://img.chuing.net/i/GNeuyp/%EA%B0%95%EB%A3%A1.jpg")
                .userId(testUserId)
                .build();

        AvatarDto savedAvatar = new AvatarDto().builder()
                .avatarId(1L)
                .avatarNm("정호 아바타")
                .avatarImg("https://img.chuing.net/i/GNeuyp/%EA%B0%95%EB%A3%A1.jpg")
                .userId(testUserId)
                .build();

        List<AvatarDto> avatars = new ArrayList<>();
        avatars.add(savedAvatar);

        verify(avatarDao,times(1)).save(avatar);
        when(avatarDao.findByUserId(testUserId)).thenReturn(avatars);

        AvatarDto newAvatar = avatarService.createAvatar(avatar);

        assertEquals(1L,newAvatar.getAvatarId());
        assertEquals("정호 아바타",newAvatar.getAvatarNm());
        assertEquals(testUserId,newAvatar.getUserId());
        assertEquals("https://img.chuing.net/i/GNeuyp/%EA%B0%95%EB%A3%A1.jpg",newAvatar.getAvatarImg());
    }

    @Test
    void TestGetAvatar() {
    }
}