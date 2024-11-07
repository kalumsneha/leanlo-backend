package com.ontariotechu.sdmt.learnlo.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
public class NamedEntity extends BaseEntity{
    private String code;
    private String name;
    private String description;
}
