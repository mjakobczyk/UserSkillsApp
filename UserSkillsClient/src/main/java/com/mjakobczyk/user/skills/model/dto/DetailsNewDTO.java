package com.mjakobczyk.user.skills.model.dto;

import java.util.UUID;

public class DetailsNewDTO {

    private String fieldOfStudy;

    private String firstName;

    private String lastName;

    private String university;

    private int yearOfStudy;

    public DetailsNewDTO(String fieldOfStudy, String firstName, String lastName,
                         String university, int yearOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.yearOfStudy = yearOfStudy;
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

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
