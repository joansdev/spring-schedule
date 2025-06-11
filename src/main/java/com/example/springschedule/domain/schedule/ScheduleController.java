package com.example.springschedule.domain.schedule;


import com.example.springschedule.domain.schedule.dto.CreateScheduleRequest;
import com.example.springschedule.domain.schedule.dto.EditScheduleRequest;
import com.example.springschedule.domain.schedule.dto.ScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponse createSchedule(@RequestBody CreateScheduleRequest requestDto) {
        return scheduleService.createSchedule(requestDto.getUserId(), requestDto.getTitle(), requestDto.getContents());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ScheduleResponse getSchedule(@PathVariable Long scheduleId) {
        return scheduleService.getSchedule(scheduleId);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponse> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/schedules/{scheduleId}")
    public ScheduleResponse updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody EditScheduleRequest requestDto
    ) {
        return scheduleService.updateSchedule(scheduleId, requestDto.getUserId(), requestDto.getTitle(), requestDto.getContents());
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);

        return ResponseEntity.ok().build();
    }
}
