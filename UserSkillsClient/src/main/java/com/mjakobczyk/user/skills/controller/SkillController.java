package com.mjakobczyk.user.skills.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjakobczyk.user.skills.model.dto.SkillDTO;
import com.mjakobczyk.user.skills.model.dto.SkillNewDTO;
import com.mjakobczyk.user.skills.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Value("${invalid.message}")
    private String invalidError;

    @RequestMapping(value = "/mainSkills", method = RequestMethod.GET)
    public String getSkills(Model model) {
        return "mainSkills";
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.GET)
    public String addSkill(Model model) {
        model.addAttribute("newSkill", new SkillNewDTO());
        return "addSkill";
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    public void addSkill(@Valid @ModelAttribute("newSkill") SkillNewDTO skillNewDTO,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ||
                skillNewDTO == null ||
                skillNewDTO.getSkillName().equals("") ||
                skillNewDTO.getSkillName() == null ||
                skillNewDTO.getSkillName().length() < 2) {
            model.addAttribute("invalid", invalidError);
        }
        else {
            skillService.createSkill(skillNewDTO);
        }
        return;
    }

    @RequestMapping(value = "/showSkills", method = RequestMethod.GET)
    public String showAllSkills(Model model) {
        List<SkillDTO> skillDTOList = skillService.getAllSkills();
        model.addAttribute("skills", skillDTOList);

        if (skillDTOList == null) {
            model.addAttribute("invalid", invalidError);
        }
        return "showSkills";
    }

}
