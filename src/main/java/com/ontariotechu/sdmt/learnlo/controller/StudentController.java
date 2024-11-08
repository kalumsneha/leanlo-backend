package com.ontariotechu.sdmt.learnlo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Student;
import com.ontariotechu.sdmt.learnlo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) throws JsonProcessingException {
        log.info("Creating Student: {}", new ObjectMapper().writeValueAsString(student));
        return this.studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        log.info("Fetching All Students");
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudentByStudentId(@PathVariable String studentId) {
        log.info("Fetching student by student id: {}", studentId);
        return Optional.ofNullable(this.studentService.getStudentByStudentId(studentId).orElseThrow(() -> new NotFoundException("Could not find student by the provided student id")));
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable String studentId, @RequestBody Student student) throws JsonProcessingException {
        log.info("Updating Student: {}", new ObjectMapper().writeValueAsString(student));
        return this.studentService.updateStudent(studentId, student);
    }


}
