package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Teacher;
import com.ontariotechu.sdmt.learnlo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher) throws JsonProcessingException {
        log.info("Creating Teacher: {}", new ObjectMapper().writeValueAsString(teacher));
        return this.teacherService.saveTeacher(teacher);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Teacher> getAllTeachers() {
        log.info("Fetching All Teachers");
        return this.teacherService.getAllTeachers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{teacherId}")
    public Optional<Teacher> getTeacherByTeacherId(@PathVariable String teacherId) {
        log.info("Fetching teacher by teacher id: {}", teacherId);
        return Optional.ofNullable(this.teacherService.getTeacherByTeacherId(teacherId).orElseThrow(() -> new NotFoundException("Could not find teacher by the provided teacher id")));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable String teacherId, @RequestBody Teacher teacher) throws JsonProcessingException {
        log.info("Updating Teacher: {}", new ObjectMapper().writeValueAsString(teacher));
        return this.teacherService.updateTeacher(teacherId, teacher);
    }

}
