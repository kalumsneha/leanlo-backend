package com.ontariotechu.sdmt.learnlo.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@SuperBuilder
@RequiredArgsConstructor
public class NamedEntity extends BaseEntity{

    @Column(name = "code", nullable = false, unique = true)
    @NotEmpty(message = "code is required")
    private String code;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "name is required")
    private String name;

    @Column(name = "description", nullable = false)
    @NotEmpty(message = "description is required")
    private String description;
}
