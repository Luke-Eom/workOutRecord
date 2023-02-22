package com.wor.demo.bodyPart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wor.demo.bodyPart.domain.BodyPart;
import com.wor.demo.bodyPart.dto.BodyPartDto;

@Mapper
public interface BodyPartMapper {
    BodyPartMapper INSTANCE = Mappers.getMapper(BodyPartMapper.class);

    @Mapping(target = "id")
    BodyPartDto bpDtoToEntity(BodyPart bodyPart);
}
