package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.model.Skill;
import com.mjakobczyk.user.skills.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public Skill createSkill(@Valid Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

}
