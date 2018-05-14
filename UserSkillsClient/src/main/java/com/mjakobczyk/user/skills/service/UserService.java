package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.model.dto.UserNewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Service
public class UserService {

    @Value("${resource.users}")
    private String createUserResource;

    @Value("${resource.users}/{id}")
    private String getUserByIdResource;

    @Value("${resource.users}/alldetails/{userId}")
    private String getAllDetailsResource;

    @Value("${resource.users}/details/{userId}")
    private String updateDetailsResource;

    @Value("${resource.users}/details/{userId}")
    private String getDetailsResource;

    @Value("${resource.users}/skills")
    private String updateSkillsResource;

    @Autowired
    private RestTemplate restTemplate;

    public UserNewDTO createUser(@Valid UserNewDTO userNewDTO) {
        System.out.println(createUserResource);
        System.out.println(userNewDTO.getEmail());
        System.out.println(userNewDTO.getName());
        return restTemplate.postForObject(createUserResource, userNewDTO,
                UserNewDTO.class);
    }


}
