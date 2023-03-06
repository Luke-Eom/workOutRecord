package com.wor.demo.user.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.wor.demo.record.domain.Record;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;


    private String nickname;

    private String gender;

    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Record> records = new ArrayList<>();
}
