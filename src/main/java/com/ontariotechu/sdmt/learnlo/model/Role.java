package com.ontariotechu.sdmt.learnlo.model;

public enum Role {
    ADMIN, STUDENT, TEACHER;

    public boolean isAdmin(){
        return this.name().equalsIgnoreCase(Role.ADMIN.name());
    }

    public boolean isStudent(){
        return this.name().equalsIgnoreCase(Role.STUDENT.name());
    }

    public boolean isTeacher(){
        return this.name().equalsIgnoreCase(Role.TEACHER.name());
    }
}
