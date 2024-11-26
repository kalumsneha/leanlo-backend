package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.StudentCourse;
import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import com.ontariotechu.sdmt.learnlo.repository.StudentCourseRepository;
import com.ontariotechu.sdmt.learnlo.service.StudentCourseService;
import com.ontariotechu.sdmt.learnlo.service.TeacherCourseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private TeacherCourseService teacherCourseService;

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

        List<StudentCourse> studentCourses;
        if(StringUtils.isEmpty(studentId) && StringUtils.isEmpty(teacherCourseId))
            studentCourses = this.studentCourseRepository.findAll();
        else
            studentCourses = this.studentCourseRepository.findAllByStudentIdOrTeacherCourseId(studentId, teacherCourseId);

        for(StudentCourse studentCourse : studentCourses){
            TeacherCourse teacherCourse = this.teacherCourseService.getTeacherCourseByTeacherCourseId(studentCourse.getTeacherCourseId()).orElseThrow(() -> new NotFoundException("Could not find teacher course by the teacher course id"));
            studentCourse.setTeacherId(teacherCourse.getTeacherId());
            studentCourse.setCourseCode(teacherCourse.getCourseCode());
            studentCourse.setVenue(teacherCourse.getVenue());
            studentCourse.setMode(teacherCourse.getMode());
            studentCourse.setDaysAndTime(teacherCourse.getDaysAndTime());
        }
        return  studentCourses;

    }
}
