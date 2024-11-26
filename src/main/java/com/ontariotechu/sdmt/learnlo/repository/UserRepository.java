package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.Role;
import com.ontariotechu.sdmt.learnlo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query(value = "SELECT * FROM user WHERE user_id=?",nativeQuery = true)
    Optional<User> findByUserId(String userId);

    List<User> findAllByRole(Role role, Pageable pageable);

    Long countByRole(Role role);
}
