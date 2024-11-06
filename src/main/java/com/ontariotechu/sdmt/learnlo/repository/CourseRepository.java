package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Long, Course> {
}
