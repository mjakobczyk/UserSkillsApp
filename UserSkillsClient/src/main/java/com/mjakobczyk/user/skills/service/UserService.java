package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.model.dto.DetailsDTO;
import com.mjakobczyk.user.skills.model.dto.DetailsFullDTO;
import com.mjakobczyk.user.skills.model.dto.UserDTO;
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

    public UserDTO createUser(@Valid UserNewDTO userNewDTO) {
        return restTemplate.postForObject(createUserResource,
                userNewDTO,
                UserDTO.class);
    }

    public UserDTO getUserInformation(String userId) {
        String finalResource = getUserByIdResource + "\\" + userId;
        return restTemplate.getForObject(finalResource,
                UserDTO.class);
    }

    public DetailsDTO getUserDetails() {
        return restTemplate.getForObject(getDetailsResource,
                DetailsDTO.class);
    }

    public DetailsFullDTO getUserFullDetails() {
        return restTemplate.getForObject(getAllDetailsResource,
                DetailsFullDTO.class);
    }

    public void updateUserDetails() {
        // TODO
    }

    public void updateUserSkills() {
        // TODO
    }
}
