package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import com.ontariotechu.sdmt.learnlo.service.TeacherCourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Teacher Course API")
@RestController
@RequestMapping("api/v1/teacher-course")
@Slf4j
public class TeacherCourseController {

    @Autowired
    private TeacherCourseService teacherCourseService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TeacherCourse saveTeacherCourse(@Validated @RequestBody TeacherCourse teacherCourse) throws JsonProcessingException {
        log.info("Assigning Course to Teacher: {}", new ObjectMapper().writeValueAsString(teacherCourse));
        return this.teacherCourseService.saveTeacherCourse(teacherCourse);
    }

    //teacher can access courses assigned to him or her
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER')")
    @GetMapping
    public List<TeacherCourse> getCoursesByTeacherIdOrCourseCode(
            @RequestParam(value = "teacherId", required = false) String teacherId,
            @RequestParam(value = "courseCode", required = false) String courseCode) {
        log.info("Fetching teacher courses. teacher id: {}, courseCode: {}", teacherId, courseCode);
        return this.teacherCourseService.getTeacherCoursesByTeacherOrCourseCode(teacherId, courseCode);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{teacherCourseId}")
    public String deleteTeacherCourse(@PathVariable String teacherCourseId){
        log.info("Deleting Teacher Course. teacherCourseId: {}", teacherCourseId);
        return this.teacherCourseService.deleteTeacherCourse(teacherCourseId);
    }

}
