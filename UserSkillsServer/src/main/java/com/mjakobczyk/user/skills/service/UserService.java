package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.exception.ResourceNotFoundException;
import com.mjakobczyk.user.skills.model.Details;
import com.mjakobczyk.user.skills.model.Skill;
import com.mjakobczyk.user.skills.model.User;
import com.mjakobczyk.user.skills.repository.DetailsRepository;
import com.mjakobczyk.user.skills.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    public User createUser(@Valid User user) {
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public Details getDetailsByUserId(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return user.getDetails();
    }

    public ResponseEntity<?> updateDetailsByUserId(UUID userId,
                                                   @Valid Details details) {
        User user = getUserById(userId);

        if (user == null) {
            return ResponseEntity.status(404).build();
        }

        Details detailsToUpdate = user.getDetails();

        if (detailsToUpdate == null) {
            return ResponseEntity.status(404).build();
        }

        detailsToUpdate.setFieldOfStudy(details.getFieldOfStudy());
        detailsToUpdate.setFirstName(details.getFirstName());
        detailsToUpdate.setLastName(details.getLastName());
        detailsToUpdate.setUniversity(details.getUniversity());
        detailsToUpdate.setYearOfStudy(details.getYearOfStudy());
        userRepository.save(user);

        return ResponseEntity.status(200).build();
    }

    public ResponseEntity<?> updateSkillsByUserId(UUID userId,
                                                  @Valid @RequestBody List<Skill> skills) {
        User user = getUserById(userId);

        if (user == null) {
            return ResponseEntity.status(404).build();
        }

        if (user.getSkills() == null) {
            user.setSkills(new ArrayList<>());
        }

        for (Skill temp : skills) {
            user.getSkills().add(temp);
        }

        userRepository.save(user);
        return ResponseEntity.status(200).build();
    }
}
