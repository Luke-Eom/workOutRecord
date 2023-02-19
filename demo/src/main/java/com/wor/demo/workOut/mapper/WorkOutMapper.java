package com.wor.demo.workOut.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wor.demo.workOut.domain.WorkOut;
import com.wor.demo.workOut.dto.WorkOutDto;

@Mapper
public interface WorkOutMapper {
    WorkOutMapper INSTANCE = Mappers.getMapper(WorkOutMapper.class);

    @Mapping(target = "id")
    WorkOutDto woDtoToEntity(WorkOut workOut);
}
