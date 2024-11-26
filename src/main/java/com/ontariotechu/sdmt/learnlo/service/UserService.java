package com.ontariotechu.sdmt.learnlo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ontariotechu.sdmt.learnlo.exception.type.ServiceException;
import com.ontariotechu.sdmt.learnlo.model.Role;
import com.ontariotechu.sdmt.learnlo.model.User;
import com.ontariotechu.sdmt.learnlo.model.base.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User createUser(User user) throws JsonProcessingException, ServiceException;

    Page<User> getUsers(Integer pageNumber, Integer pageSize, Role role);

    Optional<User> getUserByUserId(String userId);

    User updateUser(String username, User user);

    User resetPassword(String userId, User user);
}
