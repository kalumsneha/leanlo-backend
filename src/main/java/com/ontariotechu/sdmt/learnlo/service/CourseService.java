package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course saveCourse(Course course);

    List<Course> getAllCourses();

    Optional<Course> getCourseByCourseCode(String courseCode);

    Course updateCourse(String courseCode, Course course);
}
