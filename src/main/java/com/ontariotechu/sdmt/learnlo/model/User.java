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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity implements UserDetails  {

    @Column(name = "user_id", nullable = false, unique = true)
    @NotEmpty(message = "userId is required")
    private String userId;//userId should be either student id for students, teacher id for teachers or a username for admin

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "password is required")
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "deactivated", nullable = false)
    private boolean deactivated;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User(String username, String password, Role role, boolean deactivated) {
        this.userId = username;
        this.password = password;
        this.role = role;
        this.deactivated = deactivated;
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userId = username;
        this.password = password;
        this.authorities = authorities;
    }


    @Override
    public String getUsername() {
        return this.getUserId();
    }
}
