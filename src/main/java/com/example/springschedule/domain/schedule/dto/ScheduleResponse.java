package com.example.springschedule.domain.schedule.dto;

import com.example.springschedule.domain.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

//@AllArgsConstructor
@Getter
public class ScheduleResponse {

    private Long id;
    private Long userId; // 작성자 이름
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ScheduleResponse of(Schedule schedule) {
        final ScheduleResponse response = new ScheduleResponse();

        response.id = schedule.getId();
        response.userId = schedule.getUserId();
        response.title = schedule.getTitle();
        response.contents = schedule.getContents();
        response.createdAt = schedule.getCreatedAt();
        response.updatedAt = schedule.getUpdatedAt();

        return response;
    }

}
