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
public class TodoDto {
    private Long todoId;
    private Date createDay;
    private String ttl;
    private String detlCn;
    private String todoStus;
    private Long vilagId;
}
