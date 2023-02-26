package com.wor.demo.user.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.wor.demo.record.domain.Record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private long id;

    private String nickname;

    private String gender;

    private int age;

    @OneToMany(mappedBy = "user", CascadeType.REMOVE)
    private List<Record> records = new ArrayList<>();
}
