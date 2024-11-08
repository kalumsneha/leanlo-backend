package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Course;
import com.ontariotechu.sdmt.learnlo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course saveCourse(@RequestBody Course course) throws JsonProcessingException {
        log.info("Creating Course: {}", new ObjectMapper().writeValueAsString(course));
        return this.courseService.saveCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        log.info("Fetching All Courses");
        return this.courseService.getAllCourses();
    }

    @GetMapping("/{courseCode}")
    public Optional<Course> getCourseByCourseCode(@PathVariable String courseCode) {
        log.info("Fetching course by course code: {}", courseCode);
        return Optional.ofNullable(this.courseService.getCourseByCourseCode(courseCode).orElseThrow(() -> new NotFoundException("Could not find course by the provided code")));
    }

    @PutMapping("/{courseCode}")
    public Course updateCourse(@PathVariable String courseCode, @RequestBody Course course) throws JsonProcessingException {
        log.info("Updating Course: {}", new ObjectMapper().writeValueAsString(course));
        return this.courseService.updateCourse(courseCode, course);
    }

    //Should we also have endpoint to deactivate a course or have that option as part of the update course above?

}
