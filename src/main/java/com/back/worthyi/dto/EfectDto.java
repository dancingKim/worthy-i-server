package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EfectDto {
    private Long efectId;
    private Long vilagStatId;
    private String efectNm;
    private Integer efectFigur;
}
