package com.mjakobczyk.user.skills.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjakobczyk.user.skills.model.dto.SkillDTO;
import com.mjakobczyk.user.skills.model.dto.SkillNewDTO;
import com.mjakobczyk.user.skills.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${fieldsError.message}")
    private String fieldsError;

    @RequestMapping(value = "/mainSkills", method = RequestMethod.GET)
    public String getSkills(Model model) {
        List<SkillDTO> skillDTOArrayList = skillService.getAllSkills();
        //model.addAttribute(...);
        return "mainSkills";
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    public String postSkill(@Valid @RequestBody SkillNewDTO skillNewDTO) {
        skillService.createSkill(skillNewDTO);
        return "addSkill";
    }

    @RequestMapping(value = "/showSkills", method = RequestMethod.GET)
    public String showAllSkills(@Valid @RequestBody SkillNewDTO skillNewDTO) {
        return "showSkills";
    }


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Skill> createSkill(@Valid @RequestBody SkillNewDTO skillNewDTO) {
//        ModelMapper modelMapper = new ModelMapper();
//        Skill skill = modelMapper.map(skillNewDTO, Skill.class);
//        return ResponseEntity.ok(skillService.createSkill(skill));
//    }
//
//    @GetMapping
//    public List<Skill> getAllSkills() {
//        return skillService.getAllSkills();
//    }


}
