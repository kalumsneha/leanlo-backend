package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.repository.StudentRepository;
import com.ontariotechu.sdmt.learnlo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

}
