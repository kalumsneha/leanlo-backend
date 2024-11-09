package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Student;
import com.ontariotechu.sdmt.learnlo.model.StudentCourse;
import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import com.ontariotechu.sdmt.learnlo.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/enrollment")
@Slf4j
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping
    public StudentCourse saveStudent(@RequestBody StudentCourse studentCourse) throws JsonProcessingException {
        log.info("Enrolling Student to Selected Course: {}", new ObjectMapper().writeValueAsString(studentCourse));
        return this.studentCourseService.saveStudentCourse(studentCourse);
    }

    @GetMapping
    public List<StudentCourse> getStudentCoursesByStudentIdOrTeacherCourse(
            @RequestParam(value = "studentId", required = false) String studentId,
            @RequestParam(value = "teacherCourseId", required = false) String teacherCourseId) {
        log.info("Fetching student courses. student id: {}, teacherCourseId: {}", studentId, teacherCourseId);
        return this.studentCourseService.getStudentCoursesByStudentIdOrTeacherCourse(studentId, teacherCourseId);
    }

    @DeleteMapping("/{studentCourseId}")
    public String deleteStudentCourse(@PathVariable String studentCourseId){
        log.info("Deleting Student Course. studentCourseId: {}", studentCourseId);
        return this.studentCourseService.deleteStudentCourse(studentCourseId);
    }

}
