package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Long, Teacher> {
}
