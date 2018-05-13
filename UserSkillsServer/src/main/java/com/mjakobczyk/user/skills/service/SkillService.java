package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.exception.ResourceNotFoundException;
import com.mjakobczyk.user.skills.model.Skill;
import com.mjakobczyk.user.skills.model.dto.SaveSkillsRequest;
import com.mjakobczyk.user.skills.model.dto.SkillDTO;
import com.mjakobczyk.user.skills.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill createSkill(@Valid Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(int id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));
    }

    public List<Skill> getSkillListFromSaveSkillsRequest(List<SkillDTO> skillDTOList) {
        if (skillDTOList == null) {
            return null;
        }

        List<Skill> skillList = new ArrayList<>();

        for (SkillDTO temp : skillDTOList) {
            Skill skill = getSkillById(temp.getId());
            skillList.add(skill);
        }

        return skillList;
    }

}
