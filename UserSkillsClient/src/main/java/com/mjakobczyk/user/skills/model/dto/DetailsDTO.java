package com.mjakobczyk.user.skills.model.dto;

import java.util.UUID;

public class DetailsDTO {

    private String fieldOfStudy;

    private String firstName;

    private String id;

    private String lastName;

    private String university;

    private int yearOfStudy;

    public DetailsDTO(String fieldOfStudy, String firstName, String id, String lastName,
                      String university, int yearOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.university = university;
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

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
