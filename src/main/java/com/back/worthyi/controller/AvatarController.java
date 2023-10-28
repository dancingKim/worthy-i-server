package com.back.worthyi.controller;

import com.back.worthyi.dto.AvatarDto;
import com.back.worthyi.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    private final AvatarService avatarService;
    @Autowired
    public AvatarController(AvatarService avatarService){
        this.avatarService = avatarService;
    }
    @PostMapping
    public ResponseEntity<AvatarDto> createAvatar(@AuthenticationPrincipal String userId, @RequestBody AvatarDto avatarDto) {
        AvatarDto savedAvatar = avatarService.createAvatar(avatarDto);
        return new ResponseEntity<>(savedAvatar, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AvatarDto> getAvatar(@AuthenticationPrincipal String userId){
        AvatarDto foundAvatar = avatarService.getAvatar(userId);
        return new ResponseEntity<>(foundAvatar, HttpStatus.OK);
    }
}