package com.example.springschedule.domain.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String name;
    private String title;
    private String contents;

}
