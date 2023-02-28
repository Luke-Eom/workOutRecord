package com.wor.demo.record.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import com.wor.demo.routine.domain.Routine;
import com.wor.demo.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private long id;

    private User user;

    private LocalDateTime date;

    @Nullable
    private List<Routine> routines = new ArrayList<>();

    public Record(LocalDateTime date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
        user.getRecords().add(this);
    }
}

    // Setter 대신 대체?
    // public void updateRecord(Record record){
    //     this.id = record.id;
    //     this.userId = record.userId;
    //     this.date = record.date;
    //     this.routines = record.routines;
    // }

// record - workOut join table : routine