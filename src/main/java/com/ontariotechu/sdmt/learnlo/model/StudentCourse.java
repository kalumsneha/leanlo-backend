package com.ontariotechu.sdmt.learnlo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ontariotechu.sdmt.learnlo.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "student_courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentCourse extends BaseEntity {

    @Column(name = "student_course_id", nullable = false, unique = true)
    @NotEmpty(message = "studentCourseId is required")
    private String studentCourseId;

    @Column(name = "student_id", nullable = false)
    @NotEmpty(message = "studentId is required")
    private String studentId;

    @Column(name = "teacher_course_id", nullable = false)
    @NotEmpty(message = "teacherCourseId is required")
    private String teacherCourseId;

    @Transient
    private String teacherId;
    @Transient
    private String courseCode;
    @Transient
    private String venue;
    @Transient
    private String mode;
    @Transient
    private String daysAndTime;
}
