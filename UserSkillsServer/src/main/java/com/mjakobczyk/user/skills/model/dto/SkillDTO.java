package com.mjakobczyk.user.skills.model.dto;

public class SkillDTO {

    private int id;

    private String skillname;

    public SkillDTO(int id, String skillname) {
        this.id = id;
        this.skillname = skillname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }
}
