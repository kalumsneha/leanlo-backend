package com.ontariotechu.sdmt.learnlo.config;

import com.ontariotechu.sdmt.learnlo.model.Role;
import com.ontariotechu.sdmt.learnlo.model.User;
import com.ontariotechu.sdmt.learnlo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        if(userService.getUserByUserId("mfernando").isEmpty())
            userService.createUser(new User("mfernando", "password1", Role.ADMIN, false));
    }
}