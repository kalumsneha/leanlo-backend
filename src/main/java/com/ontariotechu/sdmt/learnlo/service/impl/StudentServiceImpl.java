package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Student;
import com.ontariotechu.sdmt.learnlo.repository.StudentRepository;
import com.ontariotechu.sdmt.learnlo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentByStudentId(String studentId) {
        return this.studentRepository.findByStudentId(studentId);
    }

    @Override
    public Student updateStudent(String studentId, Student student) {
        Student studentToUpdate = this.studentRepository.findByStudentId(studentId).orElseThrow(() -> new NotFoundException("Could not find student by the provided student id"));
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setPhoneNumber(student.getPhoneNumber());
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setMiddleName(student.getMiddleName());
        studentToUpdate.setLastName(student.getLastName());
        return this.studentRepository.save(studentToUpdate);
    }
}
