package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvatarDto {
    private Long avatarId;
    private String avatarNm;
    private String avatarImg;
    private String userId;
}
