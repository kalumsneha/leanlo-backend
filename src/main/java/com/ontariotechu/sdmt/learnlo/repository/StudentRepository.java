package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Long, Student> {
}
