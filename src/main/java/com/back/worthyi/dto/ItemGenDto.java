package com.back.worthyi.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemGenDto {
    private Long itemGenId;
    private String itemGenNm;
    private Date itemGenDay;
    private String itemGenPlace;
}
