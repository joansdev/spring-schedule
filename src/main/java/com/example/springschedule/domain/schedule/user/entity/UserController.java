package com.example.springschedule.domain.schedule.user.entity;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody CreateUserRequest requestDto) {
        return userService.createUser(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
    }

    @GetMapping("/users/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/users")
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/users/{userId}")
    public UserResponse updateUser(
            @PathVariable Long userId,
            @RequestBody EditUserRequest requestDto
    ) {
        return userService.updateUser(userId, requestDto.getName(), requestDto.getEmail());
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
