package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Long> {
    Optional<TeacherCourse> getTeacherCourseByTeacherId(String teacherId);

    Optional<TeacherCourse> findByTeacherCourseId(String teacherCourseId);

    List<TeacherCourse> findAllByTeacherIdOrCourseCode(String teacherId, String courseCode);

    @Query("select new com.ontariotechu.sdmt.learnlo.model.TeacherCourse(teacherCourseId, teacherId, courseCode, venue, mode, daysAndTime) from TeacherCourse where teacherCourseId not in (select teacherCourseId from StudentCourse where studentId = :studentId)")
    List<TeacherCourse> findAllTeacherCoursesForEnrollment(String studentId);

}
