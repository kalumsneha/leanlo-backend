package com.ontariotechu.sdmt.learnlo.model.base;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(name = "Code", example = "some-code", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "code", nullable = false, unique = true)
    @NotEmpty(message = "code is required")
    private String code;

    @Schema(name = "Name", example = "Some Name", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "name", nullable = false)
    @NotEmpty(message = "name is required")
    private String name;

    @Schema(name = "Description", example = "Some Description", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "description", nullable = false)
    @NotEmpty(message = "description is required")
    private String description;
}
