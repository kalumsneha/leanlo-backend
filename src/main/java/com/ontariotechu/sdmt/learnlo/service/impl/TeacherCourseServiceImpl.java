package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import com.ontariotechu.sdmt.learnlo.repository.TeacherCourseRepository;
import com.ontariotechu.sdmt.learnlo.service.TeacherCourseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherCourseServiceImpl implements TeacherCourseService {

    @Autowired
    private TeacherCourseRepository teacherCourseRepository;

    @Override
    public TeacherCourse saveTeacherCourse(TeacherCourse teacherCourse) {
        return this.teacherCourseRepository.save(teacherCourse);
    }

    @Override
    public List<TeacherCourse> getTeacherCoursesByTeacherOrCourseCode(String teacherId, String courseCode, String studentId) {
        List<TeacherCourse> teacherCourses;

        if(!StringUtils.isEmpty(studentId))
            teacherCourses = this.teacherCourseRepository.findAllTeacherCoursesForEnrollment(studentId);
        else {
            if(StringUtils.isEmpty(teacherId) && StringUtils.isEmpty(courseCode))
                teacherCourses = this.teacherCourseRepository.findAll();
            else
                teacherCourses = this.teacherCourseRepository.findAllByTeacherIdOrCourseCode(teacherId, courseCode);
        }


        return teacherCourses;
    }

    @Override
    public String deleteTeacherCourse(String teacherCourseId) {
        TeacherCourse teacherCourse = this.teacherCourseRepository.findByTeacherCourseId(teacherCourseId).orElseThrow(() -> new NotFoundException("Could not find teacher course by the provided teacher course id"));
        this.teacherCourseRepository.delete(teacherCourse);
        return "Successfully deleted entry for teacher course";
    }

    @Override
    public Optional<TeacherCourse> getTeacherCourseByTeacherCourseId(String teacherCourseId) {
        return this.teacherCourseRepository.findByTeacherCourseId(teacherCourseId);
    }
}
