package com.example.springschedule.domain.schedule;

import com.example.springschedule.domain.schedule.dto.ScheduleResponse;
import com.example.springschedule.domain.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponse createSchedule(String name, String title, String contents) {
        final LocalDateTime now = LocalDateTime.now();

        Schedule newSchedule = new Schedule(name, title, contents, now, now);

        Schedule savedSchedule = scheduleRepository.save(newSchedule);

        return ScheduleResponse.of(savedSchedule);
    }
}
