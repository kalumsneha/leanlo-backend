package com.ontariotechu.sdmt.learnlo.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@SuperBuilder
@RequiredArgsConstructor
public class NamedEntity extends BaseEntity{
    private String code;
    private String name;
    private String description;
}
