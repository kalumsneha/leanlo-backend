package com.ontariotechu.sdmt.learnlo.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class BasicInfoEntity extends BaseEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
