package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.repository.StudentCourseRepository;
import com.ontariotechu.sdmt.learnlo.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

}
