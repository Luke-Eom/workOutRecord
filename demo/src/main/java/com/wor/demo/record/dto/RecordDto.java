package com.wor.demo.record.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.wor.demo.record.domain.Record;
import com.wor.demo.routine.domain.Routine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class RecordDto {
    
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RecordResponseDto {
        private long id;

        private Long userId;

        private LocalDateTime date;

        private List<Long> routineIds;

    }

    public static RecordResponseDto toResponseDto(Record record) {
        return new RecordResponseDto(
            record.getId(),
            record.getUser().getId(),
            record.getDate(),
            record.getRoutines().stream().map(Routine::getId).collect(Collectors.toList())
            );

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private long userId;

        private LocalDateTime date;

    }
}
