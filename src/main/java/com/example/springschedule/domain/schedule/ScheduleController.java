package com.example.springschedule.domain.schedule;


import com.example.springschedule.domain.schedule.dto.CreateScheduleRequest;
import com.example.springschedule.domain.schedule.dto.ScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponse createSchedule(@RequestBody CreateScheduleRequest requestDto) {
        return scheduleService.createSchedule(requestDto.getName(), requestDto.getTitle(), requestDto.getContents());
    }
}
