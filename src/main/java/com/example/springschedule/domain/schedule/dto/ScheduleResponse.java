package com.example.springschedule.domain.schedule.dto;

import com.example.springschedule.domain.schedule.entity.Schedule;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@AllArgsConstructor
@Getter
public class ScheduleResponse {

    private Long id;
    private String name; // 작성자 이름
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ScheduleResponse of(Schedule schedule) {
        final ScheduleResponse response = new ScheduleResponse();

        response.id = schedule.getId();
        response.name = schedule.getName();
        response.title = schedule.getTitle();
        response.contents = schedule.getContents();
        response.createdAt = schedule.getCreatedAt();
        response.updatedAt = schedule.getUpdatedAt();

        return response;
    }

}
