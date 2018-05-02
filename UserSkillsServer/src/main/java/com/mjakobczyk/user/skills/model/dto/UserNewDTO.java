package com.mjakobczyk.user.skills.model.dto;

public class UserNewDTO {

    private String email;

    private String name;

    public UserNewDTO() {

    }

    public UserNewDTO(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
