package com.wor.demo.routine.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.wor.demo.record.domain.Record;
import com.wor.demo.workOut.domain.WorkOut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Routine {
    
    @Id
    private long id;

    // N:1
    @ManyToOne
    private Record recordId;

    //참조만 1:1 단방향 
    @OneToOne
    @JoinColumn(name = "work_out_id")
    private WorkOut workOutId;
    
    private int sets;

    private long weights;

    private int reps;
   
}
