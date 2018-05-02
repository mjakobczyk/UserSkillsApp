package com.mjakobczyk.user.skills.model.dto;

public class SkillNewDTO {

    private String skillName;

    public SkillNewDTO(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
