package com.mjakobczyk.user.skills.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjakobczyk.user.skills.model.dto.*;
import com.mjakobczyk.user.skills.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String show(Model model) {
        //model.addAttribute("newUser", new UserNewDTO());
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "index";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(Model model,
                             @Valid @ModelAttribute("newUser") UserNewDTO userNewDTO) {
        userService.createUser(userNewDTO);
        return "users";
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody User user) {
//        try {
//            User tempUser = userService.createUser(user);
//            ModelMapper modelMapper = new ModelMapper();
//            UserDTO userDTO = modelMapper.map(tempUser, UserDTO.class);
//            return ResponseEntity.ok(userDTO);
//        }
//        catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(404).build();
//        }
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<UserDTO> getUserDTOById(@PathVariable(value = "id") UUID id) {
//        try {
//            User user = userService.getUserById(id);
//            ModelMapper modelMapper = new ModelMapper();
//            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//            return ResponseEntity.ok(userDTO);
//        }
//        catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(404).build();
//        }
//    }
//
//    @GetMapping("/alldetails/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<DetailsFullDTO> getDetailsDTOByUserId(@PathVariable(value = "userId") UUID id) {
//        try {
//            Details details = userService.getDetailsByUserId(id);
//            ModelMapper modelMapper = new ModelMapper();
//            DetailsFullDTO detailsFullDTO = modelMapper.map(details, DetailsFullDTO.class);
//            User user = userService.getUserById(id);
//            UserFullDTO userFullDTO = modelMapper.map(user, UserFullDTO.class);
//            userFullDTO.setSkills(user.getSkills());
//            if (user.getSkills() != null) System.out.println(user.getSkills());
//            detailsFullDTO.setUserFullDTO(userFullDTO);
//            return ResponseEntity.ok(detailsFullDTO);
//        }
//        catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(404).build();
//        }
//    }
//
//    @GetMapping("/details/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<DetailsDTO> getDetailsByUserId(@PathVariable(value = "userId") UUID userId) {
//        try {
//            Details details = userService.getDetailsByUserId(userId);
//            ModelMapper modelMapper = new ModelMapper();
//            DetailsDTO detailsDTO = modelMapper.map(details, DetailsDTO.class);
//            return ResponseEntity.ok(detailsDTO);
//        }
//        catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(404).build();
//        }
//    }
//
//    @PutMapping("/details/{userId}")
//    public ResponseEntity<?> updateDetailsByUserId(@PathVariable(value = "userId") UUID userId,
//                                                   @Valid @RequestBody DetailsNewDTO detailsNewDTO) {
//        try {
//            ModelMapper modelMapper = new ModelMapper();
//            Details details = modelMapper.map(detailsNewDTO, Details.class);
//            return userService.updateDetailsByUserId(userId, details);
//        }
//        catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(404).build();
//        }
//    }
//
//    @PutMapping("/skills")
//    public ResponseEntity<?> updateUserSkills(@Valid @RequestBody SaveSkillsRequest saveSkillsRequest) {
//        try {
//            List<Skill> skillList = skillService.getSkillListFromSaveSkillsRequest(saveSkillsRequest.getSkillsIds());
//            User user = userService.getUserById(saveSkillsRequest.getUserId());
//
//            if (skillList == null || user == null) {
//                return ResponseEntity.status(404).build();
//            }
//
//            return userService.updateSkillsByUserId(user.getId(), skillList);
//        }
//        catch (ResourceNotFoundException e) {
//            return ResponseEntity.status(404).build();
//        }
//    }

}
