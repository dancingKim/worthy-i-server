package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VilagIntfDto {
    private Long vialgIntfId;
    private String vilagSubjt;
    private String intfCreatUser;
    private String vilagNm;
}
