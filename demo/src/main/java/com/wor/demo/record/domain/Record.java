package com.wor.demo.record.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import com.wor.demo.routine.domain.Routine;

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
    private long id;

    private String userId;

    private LocalDateTime date;

    @Nullable
    private List<Routine> routines = new ArrayList<>();

    

    // public void setUser(User user) {
    //     this.user = user;
    //     user.getRecords().add(this);
    // }
}
// record - workOut join table : routine