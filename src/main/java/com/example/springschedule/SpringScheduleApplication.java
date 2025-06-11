package com.example.springschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScheduleApplication.class, args);
    }

}
