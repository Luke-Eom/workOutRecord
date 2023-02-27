package com.wor.demo.routine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoutineDto {
    private long id;

     private long recordId;

     private long workOutId;
     
     private int sets;
 
     private long weights;
 
     private int reps;
    
}
