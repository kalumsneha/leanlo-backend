package com.ontariotechu.sdmt.learnlo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ontariotechu.sdmt.learnlo.model.base.BasicInfoEntity;
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
@Table(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher extends BasicInfoEntity {

    @Column(name = "teacher_id", nullable = false, unique = true)
    @NotEmpty(message = "teacherId is required")
    private String teacherId;

    @Column(name = "office_hours", nullable = false)
    @NotEmpty(message = "officeHours is required")
    private String officeHours;

    @Column(name = "office_location", nullable = false)
    @NotEmpty(message = "officeLocation is required")
    private String officeLocation;

}
