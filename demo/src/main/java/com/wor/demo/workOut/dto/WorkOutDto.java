package com.wor.demo.workOut.dto;

import com.wor.demo.bodyPart.dto.BodyPartDto;

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

    private BodyPartDto bodyPartId;

}