package com.wor.demo.routine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wor.demo.routine.domain.Routine;
import com.wor.demo.routine.dto.RoutineDto;

@Mapper
public interface RoutineMapper {
    RoutineMapper INSTANCE = Mappers.getMapper(RoutineMapper.class);

    @Mapping(target ="id")
    Routine rtDtoToEntity(RoutineDto rtDto);
}
