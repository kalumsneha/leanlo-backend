package com.ontariotechu.sdmt.learnlo.controller;

import com.ontariotechu.sdmt.learnlo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

}
