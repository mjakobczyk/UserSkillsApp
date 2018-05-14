package com.mjakobczyk.user.skills.model.dto;

import java.util.List;
import java.util.UUID;

public class SaveSkillsRequest {

    private List<Integer> skillsIds;

    private UUID userId;

    public List<Integer> getSkillsIds() {
        return skillsIds;
    }

    public void setSkillsIdskillsIds(List<Integer> skillsIds) {
        this.skillsIds = skillsIds;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
