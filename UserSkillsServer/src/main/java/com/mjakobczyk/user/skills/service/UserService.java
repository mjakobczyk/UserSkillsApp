package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.exception.ResourceNotFoundException;
import com.mjakobczyk.user.skills.model.Details;
import com.mjakobczyk.user.skills.model.User;
import com.mjakobczyk.user.skills.repository.DetailsRepository;
import com.mjakobczyk.user.skills.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DetailsRepository detailsRepository;

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

    public ResponseEntity<?> updateDetailsByUserId(UUID userId, @Valid Details details) {
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

}
