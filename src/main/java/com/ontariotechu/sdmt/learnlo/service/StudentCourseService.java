package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.model.StudentCourse;

import java.util.List;
import java.util.Optional;

public interface StudentCourseService {
    StudentCourse saveStudentCourse(StudentCourse studentCourse);

    String deleteStudentCourse(String studentCourseId);

    List<StudentCourse> getStudentCoursesByStudentIdOrTeacherCourse(String studentId, String teacherCourseId);
}
