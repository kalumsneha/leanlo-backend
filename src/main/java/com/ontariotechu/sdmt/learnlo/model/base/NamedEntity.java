package com.ontariotechu.sdmt.learnlo.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class NamedEntity extends BaseEntity{
    private String code;
    private String name;
    private String description;
}
