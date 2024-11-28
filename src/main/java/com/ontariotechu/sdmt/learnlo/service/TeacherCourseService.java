package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;

import java.util.List;
import java.util.Optional;

public interface TeacherCourseService {
    TeacherCourse saveTeacherCourse(TeacherCourse teacherCourse);

    List<TeacherCourse> getTeacherCoursesByTeacherOrCourseCode(String teacherId, String courseCode, String studentId);

    String deleteTeacherCourse(String teacherCourseId);

    Optional<TeacherCourse> getTeacherCourseByTeacherCourseId(String teacherCourseId);

}
