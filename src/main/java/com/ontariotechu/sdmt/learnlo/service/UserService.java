package com.ontariotechu.sdmt.learnlo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ontariotechu.sdmt.learnlo.exception.type.ServiceException;
import com.ontariotechu.sdmt.learnlo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user) throws JsonProcessingException, ServiceException;

    List<User> getUsers();

    Optional<User> getUserByUserId(String userId);

    User updateUser(String username, User user);

    UserDetails loadUserByUserId(String userId) throws UsernameNotFoundException;

    User resetPassword(String userId, User user);
}
