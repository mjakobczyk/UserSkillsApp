package com.mjakobczyk.user.skills.model.dto;

import com.mjakobczyk.user.skills.model.Skill;

import java.util.ArrayList;
import java.util.UUID;

public class UserFullDTO {

    private String id;

    private String email;

    private String name;

    private String password;

    ArrayList<Skill> skills;

    public UserFullDTO() {

    }

    public UserFullDTO(String id, String email, String name, String password,
                       ArrayList<Skill> skills) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
