package com.mjakobczyk.user.skills.model.dto;

import java.util.List;
import java.util.UUID;

public class SaveSkillsRequest {

    private List<SkillDTO> skillDTOList;

    private UUID userId;

    public List<SkillDTO> getSkillDTOList() {
        return skillDTOList;
    }

    public void setSkillDTOList(List<SkillDTO> skillDTOList) {
        this.skillDTOList = skillDTOList;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
