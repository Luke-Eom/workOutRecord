package com.wor.demo.workOut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkOutDto {
    private long id;

    private String name;

    private int bodyPartId;

}