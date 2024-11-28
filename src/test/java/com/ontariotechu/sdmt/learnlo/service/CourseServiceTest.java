package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.model.Course;
import com.ontariotechu.sdmt.learnlo.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @MockBean
    CourseRepository courseRepository;

    private Course course;
    private List<Course> courses;

    @BeforeEach
    void setUp() {
        course = Course.builder()
                .code("SDTM1001")
                .name("Software Development Tools and Methods")
                .description("Software Development Tools and Methods")
                .id(1L)
                .build();
        this.courses = List.of(course);

        Mockito.when(this.courseRepository.findAll(Sort.by(Sort.Direction.DESC, "name")))
                .thenReturn(courses);
        Mockito.when(this.courseRepository.findByCode("SDTM1001"))
                .thenReturn(Optional.ofNullable(course));
        Mockito.when(this.courseRepository.save(course))
                .thenReturn(course);
    }

    @Test
    void saveCourse() {
        Course savedCourse = this.courseService.saveCourse(this.course);
        assertNotEquals(savedCourse, null);
        assertEquals(savedCourse.getId(), this.course.getId());
        assertEquals(savedCourse.getCode(), this.course.getCode());
    }

    @Test
    void getAllCourses() {
        List<Course>queriedCourses = this.courseService.getAllCourses();
        assertNotEquals(queriedCourses, null);
        assertFalse(queriedCourses.isEmpty());
        assertEquals(queriedCourses.getFirst().getCode(), "SDTM1001");
    }

    @Test
    void getCourseByCourseCode() {
        Optional<Course> queriedCourse = this.courseService.getCourseByCourseCode("SDTM1001");
        assertTrue(queriedCourse.isPresent());
        assertNotEquals(queriedCourse.get(), null);
        assertEquals(queriedCourse.get().getCode(), "SDTM1001");
    }

    @Test
    void updateCourse() {
        Course updatedCourse = this.courseService.updateCourse(this.course.getCode(), this.course);
        assertNotEquals(updatedCourse, null);
        assertEquals(updatedCourse.getId(), this.course.getId());
        assertEquals(updatedCourse.getCode(), this.course.getCode());
    }
}