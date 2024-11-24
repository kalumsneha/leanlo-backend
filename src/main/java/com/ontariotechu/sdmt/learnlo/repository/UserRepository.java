package com.ontariotechu.sdmt.learnlo.repository;

import com.ontariotechu.sdmt.learnlo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE user_id=?",nativeQuery = true)
    Optional<User> findByUserId(String userId);

}
