package com.back.worthyi.controller;

import com.back.worthyi.dto.AvatarDto;
import com.back.worthyi.service.AvatarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AvatarControllerTest {
    @Mock
    private AvatarService avatarService;

    @InjectMocks
    private AvatarController avatarController;

    String testUserId;

    @BeforeEach
    public void creatTestUserId(){
        testUserId = UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    void TestCreateAvatar(){
//        String testUserId = UUID.randomUUID().toString().replace("-", "");


        AvatarDto avatar = new AvatarDto().builder()
                .avatarNm("정호 아바타")
                .avatarImg("https://img.chuing.net/i/GNeuyp/%EA%B0%95%EB%A3%A1.jpg")
                .build();

        AvatarDto savedAvatar = new AvatarDto().builder()
                .avatarId(1L)
                .avatarNm("정호 아바타")
                .avatarImg("https://img.chuing.net/i/GNeuyp/%EA%B0%95%EB%A3%A1.jpg")
                .userId(testUserId)
                .build();

                avatar.builder().userId(testUserId).build();
        when(avatarService.createAvatar(any(AvatarDto.class))).thenReturn(savedAvatar);

        ResponseEntity<AvatarDto> response = avatarController.createAvatar(testUserId,avatar);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getAvatarId());
        assertEquals("정호 아바타", response.getBody().getAvatarNm());
        assertEquals(testUserId, response.getBody().getUserId());
    }

    @Test
    public void TestGetAvatarByUserId() throws Exception {
        AvatarDto foundAvatar = new AvatarDto().builder()
                .avatarId(1L)
                .avatarNm("정호 아바타")
                .avatarImg("https://img.chuing.net/i/GNeuyp/%EA%B0%95%EB%A3%A1.jpg")
                .userId(testUserId)
                .build();

        when(avatarService.getAvatar(testUserId)).thenReturn(foundAvatar);

        ResponseEntity<AvatarDto> response = avatarController.getAvatar(testUserId);
        //@AuthenticationPrincipal String uesrId가 spring security 작동 없이도 받아질까?

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getAvatarId());
        assertEquals("정호 아바타", response.getBody().getAvatarNm());
        assertEquals(testUserId, response.getBody().getUserId());
    }
}