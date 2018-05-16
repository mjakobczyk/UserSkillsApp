package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.xml.soap.Detail;
import javax.xml.ws.Response;

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

    public UserDTO getUserInformation(@PathVariable(value = "id") String id) {
        return restTemplate.getForObject(getUserByIdResource,
                UserDTO.class, id);
    }

    public DetailsDTO getUserDetails(@PathVariable(value = "userId") String id) {
        return restTemplate.getForObject(getDetailsResource,
                DetailsDTO.class, id);
    }

    public DetailsFullDTO getUserFullDetails(@PathVariable(value = "userId") String id) {
        return restTemplate.getForObject(getAllDetailsResource,
                DetailsFullDTO.class, id);
    }

    public DetailsNewDTO updateUserDetails(@PathVariable(value = "userId") String id,
                                                          @Valid @RequestBody DetailsNewDTO detailsNewDTO) {
        return restTemplate.exchange(updateDetailsResource, HttpMethod.PUT,
                new HttpEntity<>(detailsNewDTO), DetailsNewDTO.class, id).getBody();
    }

    public SaveSkillsRequest updateUserSkills(@Valid @RequestBody SaveSkillsRequest saveSkillsRequest) {
        return restTemplate.exchange(updateSkillsResource, HttpMethod.PUT,
                new HttpEntity<>(saveSkillsRequest), SaveSkillsRequest.class,
                saveSkillsRequest.getUserId()).getBody();
    }
}
