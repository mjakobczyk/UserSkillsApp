package com.mjakobczyk.user.skills.model.dto;

import java.util.ArrayList;
import java.util.UUID;

public class UserFullDTO {

    private UUID id;

    private String email;

    private String name;

    private String password;

    ArrayList<SkillDTO> skillDTOS;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public ArrayList<SkillDTO> getSkillDTOS() {
        return skillDTOS;
    }

    public void setSkillDTOS(ArrayList<SkillDTO> skillDTOS) {
        this.skillDTOS = skillDTOS;
    }
}