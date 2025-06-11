package com.example.springschedule.domain.schedule;

import com.example.springschedule.domain.schedule.dto.EditScheduleRequest;
import com.example.springschedule.domain.schedule.dto.ScheduleResponse;
import com.example.springschedule.domain.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse createSchedule(String name, String title, String contents) {

        final Schedule newSchedule = Schedule.builder()
                .name(name)
                .title(title)
                .contents(contents)
                .build();

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


    @Transactional
    public ScheduleResponse updateSchedule(Long scheduleId, String name, String title, String contents) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Does not exist schedule"));

        schedule.edit(name, title, contents);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return ScheduleResponse.of(savedSchedule);
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Does not exist schedule"));
        scheduleRepository.delete(schedule);
    }
}
