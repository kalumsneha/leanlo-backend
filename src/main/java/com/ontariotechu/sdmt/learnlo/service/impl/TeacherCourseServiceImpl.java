package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.repository.TeacherCourseRepository;
import com.ontariotechu.sdmt.learnlo.service.TeacherCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherCourseServiceImpl implements TeacherCourseService {

    @Autowired
    private TeacherCourseRepository teacherCourseRepository;

}
