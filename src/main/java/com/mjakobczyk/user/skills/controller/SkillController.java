package com.mjakobczyk.user.skills.controller;

import com.mjakobczyk.user.skills.model.Skill;
import com.mjakobczyk.user.skills.model.dto.SkillNewDTO;
import com.mjakobczyk.user.skills.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Skill> createSkill(@Valid @RequestBody SkillNewDTO skillNewDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Skill skill = modelMapper.map(skillNewDTO, Skill.class);
        return ResponseEntity.ok(skillService.createSkill(skill));
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

}
