package com.mjakobczyk.user.skills.model.dto;

public class SkillDTO {

    private int id;

    private String skillName;

    public SkillDTO(int id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillname() {
        return skillName;
    }

    public void setSkillname(String skilName) {
        this.skillName = skillName;
    }
}
