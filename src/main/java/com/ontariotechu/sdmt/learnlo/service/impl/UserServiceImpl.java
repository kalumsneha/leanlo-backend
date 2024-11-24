package com.ontariotechu.sdmt.learnlo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sdmt.learnlo.exception.type.DuplicateException;
import com.ontariotechu.sdmt.learnlo.exception.type.NotFoundException;
import com.ontariotechu.sdmt.learnlo.exception.type.ServiceException;
import com.ontariotechu.sdmt.learnlo.exception.type.UnauthorizedException;
import com.ontariotechu.sdmt.learnlo.model.User;
import com.ontariotechu.sdmt.learnlo.repository.UserRepository;
import com.ontariotechu.sdmt.learnlo.service.StudentService;
import com.ontariotechu.sdmt.learnlo.service.TeacherService;
import com.ontariotechu.sdmt.learnlo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) throws JsonProcessingException, ServiceException {

        log.info("Creating User: {}", new ObjectMapper().writeValueAsString(user));
        try{

            //validate student id
            if(user.getRole().isStudent() && this.studentService.getStudentByStudentId(user.getUserId()).isEmpty()) throw new NotFoundException("Invalid User ID. Student not registered.");
            if(user.getRole().isTeacher() && this.teacherService.getTeacherByTeacherId(user.getUserId()).isEmpty()) throw new NotFoundException("Invalid User ID. Teacher not onboarded.");

            //encrypt password
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return this.userRepository.save(user);
        }
        catch (ConstraintViolationException | DataIntegrityViolationException ex){
            log.error("Unable to create user. {}", ex.getMessage());
            throw new DuplicateException("Duplicate Entry");
        }
        catch (Exception ex){
            log.error("Unable to create user. {}", ex.getMessage());
            throw new ServiceException("Unable to create user");
        }
    }

    @Override
    public List<User> getUsers(){
        log.info("Fetching Users");
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUserId(String userId) {
        return this.userRepository.findByUserId(userId);
    }

    @Override
    public User updateUser(String userId, User user) {
        User userToUpdate = this.userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("Could not find user by the provided user id"));
        userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        userToUpdate.setDeactivated(user.isDeactivated());
        userToUpdate.setRole(user.getRole());
        return this.userRepository.save(userToUpdate);
    }

    @Override
    public UserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUserId(userId);

        Set<GrantedAuthority> authorities = null;
        if(user.isPresent()){
            authorities = Set.of(new SimpleGrantedAuthority("ROLE_".concat(user.get().getRole().name())));

            return new org.springframework.security.core.userdetails.User(
                    userId,
                    user.get().getPassword(),
                    authorities
            );
        }

        throw new UnauthorizedException("User not found. Unauthorized!");


    }

    @Override
    public User resetPassword(String userId, User user) {
        User userToUpdate = this.userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("Could not find user by the provided user id"));
        userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));

        return this.userRepository.save(userToUpdate);
    }

}