package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.StudentCourse;
import com.ontariotechu.sdmt.learnlo.repository.StudentCourseRepository;
import com.ontariotechu.sdmt.learnlo.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return this.studentCourseRepository.save(studentCourse);
    }

    @Override
    public String deleteStudentCourse(String studentCourseId) {
        StudentCourse studentCourse = this.studentCourseRepository.findByStudentCourseId(studentCourseId).orElseThrow(() -> new NotFoundException("Could not find student course by the provided student course id"));
        this.studentCourseRepository.delete(studentCourse);
        return "Successfully deleted entry for student course";    }

    @Override
    public List<StudentCourse> getStudentCoursesByStudentIdOrTeacherCourse(String studentId, String teacherCourseId) {
        return this.studentCourseRepository.findAllByStudentIdOrTeacherCourseId(studentId, teacherCourseId);
    }
}
