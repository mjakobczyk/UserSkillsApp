package com.mjakobczyk.user.skills.model.dto;

import java.util.List;

public class SaveSkillsRequest {

    private List<SkillDTO> skillDTOList;

    private String userId;

    public List<SkillDTO> getSkillDTOList() {
        return skillDTOList;
    }

    public void setSkillDTOList(List<SkillDTO> skillDTOList) {
        this.skillDTOList = skillDTOList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
