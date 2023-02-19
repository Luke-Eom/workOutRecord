package com.wor.demo.workOut.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkOut {
    @Id
    private long id;

    private String name;

    private String bodyPart; // 신체 부위, 기구운동 여부

    private boolean machine;
}
