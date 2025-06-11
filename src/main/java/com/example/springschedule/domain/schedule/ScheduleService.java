package com.example.springschedule.domain.schedule;

import com.example.springschedule.domain.schedule.dto.ScheduleResponse;
import com.example.springschedule.domain.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponse createSchedule(String name, String title, String contents) {

        final Schedule newSchedule = new Schedule(name, title, contents);

        Schedule savedSchedule = scheduleRepository.save(newSchedule);

        return ScheduleResponse.of(savedSchedule);
    }

    public ScheduleResponse getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Does not exist schedule"));
        return ScheduleResponse.of(schedule);
    }

    public List<ScheduleResponse> getAllSchedules() {
        List<Schedule> allScheduls = scheduleRepository.findAll();

        return allScheduls.stream().map(ScheduleResponse::of).toList();
    }
}
