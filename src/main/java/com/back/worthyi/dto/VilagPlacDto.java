package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VilagPlacDto {
    private Long vilagPlacId;
    private String vilagPlacNm;
    private String vilagPlacRoleCd;
    private String vilagPlacImg;
    private Long vialgIntfId;
}
