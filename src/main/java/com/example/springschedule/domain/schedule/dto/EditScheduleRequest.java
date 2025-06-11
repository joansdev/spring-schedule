package com.example.springschedule.domain.schedule.dto;

import lombok.Getter;

@Getter
public class EditScheduleRequest {

    private Long userId;
    private String title;
    private String contents;

}
