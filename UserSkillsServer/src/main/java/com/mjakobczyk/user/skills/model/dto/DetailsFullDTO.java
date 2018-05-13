package com.mjakobczyk.user.skills.model.dto;

import com.mjakobczyk.user.skills.model.User;

import java.util.UUID;

public class DetailsFullDTO {

    private UUID detailsId;

    private String fieldOfStudy;

    private String firstName;

    private String lastName;

    private String university;

    private UserFullDTO userFullDTO;

    private int yearOfStudy;

    public UUID getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(UUID detailsId) {
        this.detailsId = detailsId;
    }

    public UserFullDTO getUserFullDTO() {
        return userFullDTO;
    }

    public void setUserFullDTO(UserFullDTO userFullDTO) {
        this.userFullDTO = userFullDTO;
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
