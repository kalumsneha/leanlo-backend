package com.ontariotechu.sdmt.learnlo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ontariotechu.sdmt.learnlo.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "teacher_courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherCourse extends BaseEntity {

    @Column(name = "teacher_course_id", nullable = false, unique = true)
    @NotEmpty(message = "teacherCourseId is required")
    private String teacherCourseId;

    @Column(name = "teacher_id", nullable = false)
    @NotEmpty(message = "teacherId is required")
    private String teacherId;

    @Column(name = "course_code", nullable = false)
    @NotEmpty(message = "courseCode is required")
    private String courseCode;

    @Column(name = "venue", nullable = false)
    @NotEmpty(message = "venue is required")
    private String venue;

    @Column(name = "mode", nullable = false)
    @NotEmpty(message = "mode is required")
    private String mode;

    @Column(name = "days_and_time", nullable = false)
    @NotEmpty(message = "daysAndTime is required")
    private String daysAndTime;
}
