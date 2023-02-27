package com.wor.demo.bodyPart.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.wor.demo.workOut.domain.WorkOut;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BodyPart {
    
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "body_part")
    private List<WorkOut> wos = new ArrayList<WorkOut>();

}
