package com.mjakobczyk.user.skills.controller;

import com.mjakobczyk.user.skills.model.dto.*;
import com.mjakobczyk.user.skills.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${fieldsError.message}")
    private String fieldsError;

    @Value("${addUserEmailError.message}")
    private String addUserEmailError;

    @Value("${invalidIdError.message}")
    private String invalidIdError;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "index";
    }

    @RequestMapping(value = "/mainUsers", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "mainUsers";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String showCreatedUser(Model model) {
        model.addAttribute("newUser", new UserNewDTO());
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void createUser(Model model,
                             @Valid @ModelAttribute("newUser") UserNewDTO userNewDTO) {
        if (    userNewDTO.getName() == null    ||
                userNewDTO.getName() == ""      ||
                userNewDTO.getEmail() == null   ||
                userNewDTO.getEmail() == "") {
            model.addAttribute("fieldsError", fieldsError);
            return;
        }
        if (!(userNewDTO.getEmail().contains("@"))) {
            model.addAttribute("addUserEmailError", addUserEmailError);
            return;
        }
        UserDTO userDTO = userService.createUser(userNewDTO);
        model.addAttribute("createdUser", userDTO);
        return;
    }

    @RequestMapping(value = "/showInformation", method = RequestMethod.GET)
    public String showUserInformationGet(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "showInformation";
    }

    @RequestMapping(value = "/showInformation", method = RequestMethod.POST)
    public void showUserInformationPost(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ||
                userDTO == null ||
                userDTO.getId() == null ||
                userDTO.getId().equals("") ||
                userDTO.getId().toString().equals("") ||
                userDTO.getId().toString() == null ||
                userDTO.getId().toString().length() < 2) {
            model.addAttribute("invalidIdError", invalidIdError);
        }
        else {
            UserDTO user = userService.getUserInformation(userDTO.getId().toString());
            model.addAttribute("user", user);
        }

        return;
    }

    @RequestMapping(value = "/showDetails", method = RequestMethod.GET)
    public String showUserDetailsGet(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "showDetails";
    }

    @RequestMapping(value = "/showDetails", method = RequestMethod.POST)
    public void showUserDetailsPost(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ||
                userDTO == null ||
                userDTO.getId() == null ||
                userDTO.getId().equals("") ||
                userDTO.getId().toString().equals("") ||
                userDTO.getId().toString() == null ||
                userDTO.getId().toString().length() < 2) {
            model.addAttribute("invalidIdError", invalidIdError);
        }
        else {
            DetailsDTO detailsDTO = userService.getUserDetails(userDTO.getId().toString());
            model.addAttribute("details", detailsDTO);
        }

        return;
    }

    @RequestMapping(value = "/showAllDetails", method = RequestMethod.GET)
    public String showAllUserDetailsGet(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "showAllDetails";
    }

    @RequestMapping(value = "/showAllDetails", method = RequestMethod.POST)
    public void showAllUserDetailsPost(@Valid @ModelAttribute("user") UserDTO userDTO,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ||
                userDTO == null ||
                userDTO.getId() == null ||
                userDTO.getId().equals("") ||
                userDTO.getId().toString().equals("") ||
                userDTO.getId().toString() == null ||
                userDTO.getId().toString().length() < 2) {
            model.addAttribute("invalidIdError", invalidIdError);
        }
        else {
            DetailsFullDTO detailsFullDTO = userService.getUserFullDetails(userDTO.getId().toString());
            model.addAttribute("details", detailsFullDTO);
            UserFullDTO userFullDTO = detailsFullDTO.getUserFullDTO();
            model.addAttribute("user", userFullDTO);
            List<SkillDTO> skillDTOList = userFullDTO.getSkillDTOList();
            model.addAttribute("skills", skillDTOList);
        }

        return;
    }

    @RequestMapping(value = "/updateDetails", method = RequestMethod.GET)
    public String updateUserDetailsGet(Model model) {
        model.addAttribute("details", new DetailsDTO());
        return "updateDetails";
    }

    @RequestMapping(value = "/updateDetails", method = RequestMethod.PUT)
    public void updateUserDetailsPost(@Valid @ModelAttribute("details") DetailsDTO detailsDTO,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ||
                detailsDTO == null ||
                detailsDTO.getId() == null ||
                detailsDTO.getId().equals("") ||
                detailsDTO.getId().toString().equals("") ||
                detailsDTO.getId().toString() == null ||
                detailsDTO.getId().toString().length() < 2) {
            model.addAttribute("invalidIdError", invalidIdError);
        }
        else {
            if (detailsDTO.getFieldOfStudy() == null) {
                detailsDTO.setFieldOfStudy("");
            }
            if (detailsDTO.getFirstName() == null) {
                detailsDTO.setFirstName("");
            }
            if (detailsDTO.getLastName() == null) {
                detailsDTO.setLastName("");
            }
            if (detailsDTO.getUniversity() == null) {
                detailsDTO.setUniversity("");
            }

            DetailsNewDTO detailsNewDTO = new DetailsNewDTO();
            detailsNewDTO.setFieldOfStudy(detailsDTO.getFieldOfStudy());
            detailsNewDTO.setFirstName(detailsDTO.getFirstName());
            detailsNewDTO.setLastName(detailsDTO.getLastName());
            detailsNewDTO.setUniversity(detailsDTO.getUniversity());
            detailsNewDTO.setYearOfStudy(detailsDTO.getYearOfStudy());

            userService.updateUserDetails(detailsDTO.getId().toString(),
                    detailsNewDTO);
        }

        return;
    }

    @RequestMapping(value = "/updateSkills", method = RequestMethod.GET)
    public String updateUserSkillsGet(Model model) {
        model.addAttribute("skills", new SaveSkillsRequest());
        return "updateSkills";
    }

    @RequestMapping(value = "/updateSkills", method = RequestMethod.PUT)
    public void updateUserSkillsPost(Model model) {
        return;
    }

}
