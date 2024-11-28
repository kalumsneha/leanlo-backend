package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.exception.type.ServiceException;
import com.ontariotechu.sdmt.learnlo.model.Role;
import com.ontariotechu.sdmt.learnlo.model.User;
import com.ontariotechu.sdmt.learnlo.model.base.Page;
import com.ontariotechu.sdmt.learnlo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "User API")
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
    public Page<User> getUsers(
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Role role) throws JsonProcessingException {
        log.info("getting users");
        return this.userService.getUsers(pageNumber, pageSize, role);
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
    @PutMapping("/reset-password")
    public User resetPassword(@RequestBody User user) throws JsonProcessingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = ((User)authentication.getPrincipal()).getUserId();
        log.info("updating user. userId: {}, user: {}", userId, new ObjectMapper().writeValueAsString(user));
        return this.userService.resetPassword(userId, user);
    }
}
