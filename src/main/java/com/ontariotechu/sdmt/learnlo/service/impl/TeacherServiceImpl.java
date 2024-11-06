package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.repository.TeacherRepository;
import com.ontariotechu.sdmt.learnlo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

}
