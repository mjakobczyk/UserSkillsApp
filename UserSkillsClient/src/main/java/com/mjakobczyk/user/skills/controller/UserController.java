package com.mjakobczyk.user.skills.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjakobczyk.user.skills.model.Details;
import com.mjakobczyk.user.skills.model.User;
import com.mjakobczyk.user.skills.model.dto.*;
import com.mjakobczyk.user.skills.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("newUser", new UserNewDTO());
        return "users";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(Model model,
                             @Valid @ModelAttribute("newUser") UserNewDTO userNewDTO) {
        userService.createUser(userNewDTO);
        return "users";
    }

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<UserDTO> getUserDTOById(@PathVariable(value = "id") UUID id) {
//        User user = userService.getUserById(id);
//        ModelMapper modelMapper = new ModelMapper();
//        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//        return ResponseEntity.ok(userDTO);
//    }
//
//    @GetMapping("/alldetails/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<DetailsFullDTO> getDetailsDTOByUserId(@PathVariable(value = "userId") UUID id) {
//        Details details = userService.getDetailsByUserId(id);
//        ModelMapper modelMapper = new ModelMapper();
//        DetailsFullDTO detailsFullDTO = modelMapper.map(details, DetailsFullDTO.class);
//        return ResponseEntity.ok(detailsFullDTO);
//    }
//
//    @GetMapping("/details/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<DetailsDTO> getDetailsByUserId(@PathVariable(value = "userId") UUID userId) {
//        Details details = userService.getDetailsByUserId(userId);
//        ModelMapper modelMapper = new ModelMapper();
//        DetailsDTO detailsDTO = modelMapper.map(details, DetailsDTO.class);
//        return ResponseEntity.ok(detailsDTO);
//    }
//
//    @PutMapping("/details/{userId}")
//    public ResponseEntity<?> updateDetailsByUserId(@PathVariable(value = "userId") UUID userId,
//                                                   @Valid @RequestBody DetailsNewDTO detailsNewDTO) {
//        ModelMapper modelMapper = new ModelMapper();
//        Details details = modelMapper.map(detailsNewDTO, Details.class);
//        return userService.updateDetailsByUserId(userId, details);
//    }
}
