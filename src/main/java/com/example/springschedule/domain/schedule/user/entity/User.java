package com.example.springschedule.domain.schedule.user.entity;

import com.example.springschedule.domain.schedule.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Builder
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void edit(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
