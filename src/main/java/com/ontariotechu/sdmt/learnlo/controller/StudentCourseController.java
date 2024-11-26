package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.model.StudentCourse;
import com.ontariotechu.sdmt.learnlo.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/enrollment")
@Slf4j
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StudentCourse saveStudentCourse(@Validated @RequestBody StudentCourse studentCourse) throws JsonProcessingException {
        log.info("Enrolling Student to Selected Course: {}", new ObjectMapper().writeValueAsString(studentCourse));
        return this.studentCourseService.saveStudentCourse(studentCourse);
    }

    //Students can access courses he or she is enrolled in. Also teachers can access students that have enrolled for their courses.
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT') or hasRole('ROLE_TEACHER')")
    @GetMapping
    public List<StudentCourse> getStudentCoursesByStudentIdOrTeacherCourse(
            @RequestParam(value = "studentId", required = false) String studentId,
            @RequestParam(value = "teacherCourseId", required = false) String teacherCourseId) {
        log.info("Fetching student courses. student id: {}, teacherCourseId: {}", studentId, teacherCourseId);
        return this.studentCourseService.getStudentCoursesByStudentIdOrTeacherCourse(studentId, teacherCourseId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{studentCourseId}")
    public String deleteStudentCourse(@PathVariable String studentCourseId){
        log.info("Deleting Student Course. studentCourseId: {}", studentCourseId);
        return this.studentCourseService.deleteStudentCourse(studentCourseId);
    }

}
