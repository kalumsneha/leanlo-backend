package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentByStudentId(String studentId);

    Student updateStudent(String studentId, Student student);
}
