package com.example.springschedule.domain.schedule.user.entity;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class EditUserRequest {

    private String name;
    private String email;

}
