package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.exception.type.ServiceException;
import com.ontariotechu.sdmt.learnlo.model.User;
import com.ontariotechu.sdmt.learnlo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createUser(@Validated @RequestBody User user) throws JsonProcessingException, ServiceException {

        log.info("Create User Request: {}", new ObjectMapper().writeValueAsString(user));
        return this.userService.createUser(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<User> getUsers() throws JsonProcessingException {
        return this.userService.getUsers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{userId}")
    public Optional<User> getUserByUserId(@PathVariable String userId) throws JsonProcessingException {
        log.info("fetching user by userId. userId: {}", userId);
        return Optional.ofNullable(this.userService.getUserByUserId(userId).orElseThrow(() -> new NotFoundException("Could not find user by the provided userId")));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User user) throws JsonProcessingException {
        log.info("updating user. userId: {}, user: {}", userId, new ObjectMapper().writeValueAsString(user));
        return this.userService.updateUser(userId, user);
    }

    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_TEACHER')")
    @PutMapping("/reset-password/{userId}")
    public User resetPassword(@PathVariable String userId, @RequestBody User user) throws JsonProcessingException {
        log.info("updating user. userId: {}, user: {}", userId, new ObjectMapper().writeValueAsString(user));
        return this.userService.resetPassword(userId, user);
    }
}
