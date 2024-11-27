package com.ontariotechu.sdmt.learnlo.controller;

import com.ontariotechu.sdmt.learnlo.model.AdminSummary;
import com.ontariotechu.sdmt.learnlo.model.Course;
import com.ontariotechu.sdmt.learnlo.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Admin API")
@RestController
@RequestMapping("api/v1/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public AdminSummary getSummaries() {
        log.info("Fetching All Courses");
        return this.adminService.getAdminSummary();
    }
}
