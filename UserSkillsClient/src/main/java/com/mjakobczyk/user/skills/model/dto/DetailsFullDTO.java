package com.mjakobczyk.user.skills.model.dto;

import com.mjakobczyk.user.skills.model.User;

import java.util.UUID;

public class DetailsFullDTO {

    private String id;

    private String fieldOfStudy;

    private String firstName;

    private String lastName;

    private String university;

    private User user;

    private int yearOfStudy;

    public DetailsFullDTO(String id, String fieldOfStudy, String firstName, String lastName,
                          String university, User user, int yearOfStudy) {
        this.id = id;
        this.fieldOfStudy = fieldOfStudy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.user = user;
        this.yearOfStudy = yearOfStudy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
