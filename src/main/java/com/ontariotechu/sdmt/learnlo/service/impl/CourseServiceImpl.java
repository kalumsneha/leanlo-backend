package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Course;
import com.ontariotechu.sdmt.learnlo.repository.CourseRepository;
import com.ontariotechu.sdmt.learnlo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    @Override
    public Optional<Course> getCourseByCourseCode(String courseCode) {
        return this.courseRepository.findByCode(courseCode);
    }

    @Override
    public Course updateCourse(String courseCode, Course course) {
        Course courseToUpdate = this.courseRepository.findByCode(courseCode).orElseThrow(() -> new NotFoundException("Could not find course by the provided course code"));
        courseToUpdate.setName(course.getName());
        courseToUpdate.setDescription(course.getDescription());
        return this.courseRepository.save(courseToUpdate);
    }
}
