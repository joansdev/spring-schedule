package com.example.springschedule.domain.schedule.common;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EnableJpaAuditing
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime creadtedAt;

    @LastModifiedDate
    protected LocalDateTime updatedAt;

}
