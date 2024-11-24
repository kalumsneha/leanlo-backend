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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity {

    @Column(name = "userId", nullable = false, unique = true)
    @NotEmpty(message = "userId is required")
    private String userId;//userId should be either student id for students, teacher id for teachers or a username for admin

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "password is required")
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "deactivated", nullable = false)
    private boolean deactivated;

}
