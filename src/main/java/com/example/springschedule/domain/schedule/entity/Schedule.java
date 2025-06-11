package com.example.springschedule.domain.schedule.entity;

import com.example.springschedule.domain.schedule.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 작성자 이름

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Schedule(String name, String title, String contents) {
        this.name = name;
        this.title = title;
        this.contents = contents;

    }

}
