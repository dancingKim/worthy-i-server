package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String userId;
    private String eid;
    private String pwd;
    private String accessToken;
    private String providerNm;
    private String authorityNm;
}
