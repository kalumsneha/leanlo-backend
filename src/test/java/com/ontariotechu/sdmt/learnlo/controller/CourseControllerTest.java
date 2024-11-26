package com.ontariotechu.sdmt.learnlo.controller;

import com.ontariotechu.sdmt.learnlo.model.Course;
import com.ontariotechu.sdmt.learnlo.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

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
    }

    @WithMockUser(username = "mfernando", roles = "ADMIN")
    @Test
    void saveCourse() throws Exception {
        Course courseToSave = Course.builder()
                .code("SDTM1001")
                .name("Software Development Tools and Methods")
                .description("Software Development Tools and Methods")
                .build();
        Mockito.when(this.courseService.saveCourse(courseToSave))
                .thenReturn(course);
        mockMvc.perform(post("/api/v1/course")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"code\" : \"SDTM1001\",\n" +
                                "    \"name\" : \"Software Development Tools and Methods\",\n" +
                                "    \"description\" : \"Software Development Tools and Methods\"\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id")
                        .value(this.course.getId()));
    }

    @WithMockUser(username = "mfernando", roles = "ADMIN")
    @Test
    void getAllCourses() throws Exception {
        Mockito.when(this.courseService.getAllCourses())
                .thenReturn(this.courses);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/course")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id")
                        .value(this.course.getId()));
    }

    @WithMockUser(username = "mfernando", roles = "ADMIN")
    @Test
    void getCourseByCourseCode() throws Exception {
        Mockito.when(this.courseService.getCourseByCourseCode(course.getCode()))
                .thenReturn(Optional.ofNullable(course));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/course/SDTM1001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(this.course.getId()));
    }

    @WithMockUser(username = "mfernando", roles = "ADMIN")
    @Test
    void updateCourse() throws Exception {
        Course courseToUpdate = Course.builder()
                .name("Software Development Tools and Methods")
                .description("Software Development Tools and Methods")
                .build();
        Mockito.when(this.courseService.updateCourse(course.getCode(), courseToUpdate))
                .thenReturn(course);
        mockMvc.perform(put("/api/v1/course/SDTM1001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf())
                        .content("{\n" +
                                "    \"name\" : \"Software Development Tools and Methods\",\n" +
                                "    \"description\" : \"Software Development Tools and Methods\"\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(this.course.getId()));
    }
}