package com.ontariotechu.sdmt.learnlo.service.impl;

import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.model.Teacher;
import com.ontariotechu.sdmt.learnlo.repository.TeacherRepository;
import com.ontariotechu.sdmt.learnlo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherByTeacherId(String teacherId) {
        return this.teacherRepository.findByTeacherId(teacherId);
    }

    @Override
    public Teacher updateTeacher(String teacherId, Teacher teacher) {
        Teacher teacherToUpdate = this.teacherRepository.findByTeacherId(teacherId).orElseThrow(() -> new NotFoundException("Could not find teacher by the provided teacher id"));
        teacherToUpdate.setOfficeHours(teacher.getOfficeHours());
        teacherToUpdate.setOfficeLocation(teacher.getOfficeLocation());
        teacherToUpdate.setEmail(teacher.getEmail());
        teacherToUpdate.setLastName(teacher.getLastName());
        teacherToUpdate.setFirstName(teacher.getFirstName());
        teacherToUpdate.setMiddleName(teacher.getMiddleName());
        teacherToUpdate.setPhoneNumber(teacher.getPhoneNumber());
        return this.teacherRepository.save(teacherToUpdate);
    }
}
