package com.wor.demo.workOut.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wor.demo.bodyPart.domain.BodyPart;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_out_id")
    private long id;

    private String name;

    // 양방향 조회 1:N
    @ManyToOne
    @JoinColumn(name = "body_part_id")
    private BodyPart bodyPartId;

}

// workOut - workOutRoutine 따로 테이블 설계
// -> 루틴 입력 시 해당 운동을 찾을때 workOut으로 빠르게 찾기
// -> 기록용 테이블은 따로 운용하여 독립적인 db로 = 사용용도에 맞게 활용
