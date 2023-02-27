package com.wor.demo.user.domain;

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
public class User {

    @Id
    private long id;

    private String nickname;

    private String gender;

    private int age;

    // @OneToMany(mappedBy = "user", CascadeType.REMOVE)
    // private List<Record> records = new ArrayList<>();
}
