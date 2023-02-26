package com.wor.demo.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.wor.demo.record.domain.Record;
import com.wor.demo.record.dto.RecordDto;

@Mapper
public interface RecordMapper {
    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);
    
    @Mapping(target = "id")
    RecordDto recordToEntity(Record record);

    @Mapping(target = "id")
    Record recordDtoToEntity(RecordDto recordDto);
}
