package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Student;
import com.ontariotechu.sdmt.learnlo.model.StudentCourse;
import com.ontariotechu.sdmt.learnlo.model.Teacher;
import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import com.ontariotechu.sdmt.learnlo.repository.TeacherCourseRepository;
import com.ontariotechu.sdmt.learnlo.service.TeacherCourseService;
import lombok.extern.slf4j.Slf4j;
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
    public List<TeacherCourse> getTeacherCoursesByTeacherOrCourseCode(String teacherId, String courseCode) {
        return this.teacherCourseRepository.findAllByTeacherIdOrCourseCode(teacherId, courseCode);
    }

    @Override
    public String deleteTeacherCourse(String teacherCourseId) {
        TeacherCourse teacherCourse = this.teacherCourseRepository.findByTeacherCourseId(teacherCourseId).orElseThrow(() -> new NotFoundException("Could not find teacher course by the provided teacher course id"));
        this.teacherCourseRepository.delete(teacherCourse);
        return "Successfully deleted entry for teacher course";
    }
}
