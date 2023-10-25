package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OauthidDto {
    private Long oauthId;
    private String userId;
    private String accessToken;
    private String providerNm;
    private String socialId;
}
