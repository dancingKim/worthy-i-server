package com.back.worthyi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VilagAvatarStatDto {
    private Long avatarId;
    private Long vilagStatId;
    private Integer avatarStat;
    private Integer statLevelFigur;
}
