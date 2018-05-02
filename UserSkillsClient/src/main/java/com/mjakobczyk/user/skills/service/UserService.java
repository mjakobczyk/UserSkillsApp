package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.exception.ResourceNotFoundException;
import com.mjakobczyk.user.skills.model.Details;
import com.mjakobczyk.user.skills.model.User;
import com.mjakobczyk.user.skills.model.dto.UserDTO;
import com.mjakobczyk.user.skills.model.dto.UserNewDTO;
import com.mjakobczyk.user.skills.repository.DetailsRepository;
import com.mjakobczyk.user.skills.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.UUID;

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

//    public UserDTO getUserById(String id) {
//        return  restTemplate.getForObject(getUserByIdResource, )
//    }

//    public Details getDetailsByUserId(UUID userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//        return user.getDetails();
//    }

//    public ResponseEntity<?> updateDetailsByUserId(UUID userId, @Valid Details details) {
//        User user = getUserById(userId);
//
//        if (user == null) {
//            return ResponseEntity.status(404).build();
//        }
//
//        Details detailsToUpdate = user.getDetails();
//
//        if (detailsToUpdate == null) {
//            return ResponseEntity.status(404).build();
//        }
//
//        detailsToUpdate.setFieldOfStudy(details.getFieldOfStudy());
//        detailsToUpdate.setFirstName(details.getFirstName());
//        detailsToUpdate.setLastName(details.getLastName());
//        detailsToUpdate.setUniversity(details.getUniversity());
//        detailsToUpdate.setYearOfStudy(details.getYearOfStudy());
//        userRepository.save(user);
//
//        return ResponseEntity.status(200).build();
//    }

}
