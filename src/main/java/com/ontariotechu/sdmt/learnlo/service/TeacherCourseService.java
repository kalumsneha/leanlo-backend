package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;

import java.util.List;

public interface TeacherCourseService {
    TeacherCourse saveTeacherCourse(TeacherCourse teacherCourse);

    List<TeacherCourse> getTeacherCoursesByTeacherOrCourseCode(String teacherId, String courseCode);

    String deleteTeacherCourse(String teacherCourseId);
}
