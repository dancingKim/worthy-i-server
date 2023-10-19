package com.back.worthyi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String eid;
    private String pwd;
    private String providerNm;
    private String accessToken;
}
