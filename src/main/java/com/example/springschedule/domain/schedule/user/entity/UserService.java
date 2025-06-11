package com.example.springschedule.domain.schedule.user.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse createUser(String name, String email, String password) {
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
        User savedUser = userRepository.save(user);
        return UserResponse.of(savedUser);
    }


    public UserResponse getUser(Long userId) {
        User user = getUserOrElseThrow(userId);
        return UserResponse.of(user);
    }


    public List<UserResponse> findAllUsers() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream().map(UserResponse::of).toList();
    }


    @Transactional
    public UserResponse updateUser(Long userId, String name, String email) {
        User user = getUserOrElseThrow(userId);

        user.edit(name, email);

        User savedUser = userRepository.save(user);

        return UserResponse.of(user);
    }


    @Transactional
    public void deleteUser(Long userId) {
        User user = getUserOrElseThrow(userId);
        userRepository.delete(user);
    }


    private User getUserOrElseThrow(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Does not exist user"));
    }

}
