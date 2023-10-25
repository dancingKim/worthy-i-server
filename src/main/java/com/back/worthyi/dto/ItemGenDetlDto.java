package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemGenDetlDto {
    private Long itemGenDetlId;
    private Long itemGenId;
    private String itemGenDetl;
}