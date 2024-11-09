package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Long> {
    Optional<TeacherCourse> getTeacherCourseByTeacherId(String teacherId);

    Optional<TeacherCourse> findByTeacherCourseId(String teacherCourseId);

    List<TeacherCourse> findAllByTeacherIdOrCourseCode(String teacherId, String courseCode);
}
