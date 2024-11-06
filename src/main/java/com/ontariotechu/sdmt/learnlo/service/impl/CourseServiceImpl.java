package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.repository.CourseRepository;
import com.ontariotechu.sdmt.learnlo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

}
