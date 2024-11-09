package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    Optional<StudentCourse> findStudentCourseByStudentId(String studentId);

    Optional<StudentCourse> findByStudentCourseId(String studentCourseId);

    List<StudentCourse> findAllByStudentIdOrTeacherCourseId(String studentId, String teacherCourseId);
}
