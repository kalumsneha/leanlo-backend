package com.ontariotechu.sdmt.learnlo.service;

import com.ontariotechu.sdmt.learnlo.exception.type.ServiceException;
import com.ontariotechu.sdmt.learnlo.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher) throws ServiceException;

    List<Teacher> getAllTeachers();

    Optional<Teacher> getTeacherByTeacherId(String teacherId);

    Teacher updateTeacher(String teacherId, Teacher teacher);
}
