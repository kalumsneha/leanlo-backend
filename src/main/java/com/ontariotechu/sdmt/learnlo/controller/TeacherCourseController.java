package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import com.ontariotechu.sdmt.learnlo.service.TeacherCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher-course")
@Slf4j
public class TeacherCourseController {

    @Autowired
    private TeacherCourseService teacherCourseService;

    @PostMapping
    public TeacherCourse saveTeacherCourse(@RequestBody TeacherCourse teacherCourse) throws JsonProcessingException {
        log.info("Assigning Course to Teacher: {}", new ObjectMapper().writeValueAsString(teacherCourse));
        return this.teacherCourseService.saveTeacherCourse(teacherCourse);
    }

    /*@GetMapping("/{teacherId}")
    public Optional<TeacherCourse> getCoursesByTeacherId(@PathVariable String teacherId) {
        log.info("Fetching courses by teacher id: {}", teacherId);
        return Optional.ofNullable(this.teacherCourseService.getCoursesByTeacherId(teacherId).orElseThrow(() -> new NotFoundException("Could not find courses assigned to the provided teacher id")));
    }

     */

    @GetMapping
    public List<TeacherCourse> getCoursesByTeacherIdOrCourseCode(
            @RequestParam(value = "teacherId", required = false) String teacherId,
            @RequestParam(value = "courseCode", required = false) String courseCode) {
        log.info("Fetching teacher courses. teacher id: {}, courseCode: {}", teacherId, courseCode);
        return this.teacherCourseService.getTeacherCoursesByTeacherOrCourseCode(teacherId, courseCode);
    }

    @DeleteMapping("/{teacherCourseId}")
    public String deleteTeacherCourse(@PathVariable String teacherCourseId){
        log.info("Deleting Teacher Course. teacherCourseId: {}", teacherCourseId);
        return this.teacherCourseService.deleteTeacherCourse(teacherCourseId);
    }

}
