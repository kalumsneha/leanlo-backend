package com.ontariotechu.sdmt.learnlo.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class BasicInfoEntity extends BaseEntity {

    @Column(name = "firstname", nullable = false)
    @NotEmpty(message = "firstName is required")
    private String firstName;

    @Column(name = "middlename")
    @NotEmpty(message = "middleName is required")
    private String middleName;

    @Column(name = "lastname", nullable = false)
    @NotEmpty(message = "lastName is required")
    private String lastName;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "email is required")
    private String email;

    @Column(name = "phone_number", nullable = false)
    @NotEmpty(message = "phoneNumber is required")
    private String phoneNumber;

}
