package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.model.AdminSummary;
import com.ontariotechu.sdmt.learnlo.repository.CourseRepository;
import com.ontariotechu.sdmt.learnlo.repository.StudentRepository;
import com.ontariotechu.sdmt.learnlo.repository.TeacherRepository;
import com.ontariotechu.sdmt.learnlo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public AdminSummary getAdminSummary(){

        long studentCnt = this.studentRepository.count();
        long courseCnt = this.courseRepository.count();
        long teacherCnt = this.teacherRepository.count();
        log.info("student count: {}, teacher count: {}, course count: {}", studentCnt, teacherCnt, courseCnt);
        return AdminSummary.builder()
                .teacherCount(teacherCnt)
                .studentCount(studentCnt)
                .courseCount(courseCnt).build();
    }
}
