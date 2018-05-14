package com.mjakobczyk.user.skills.service;

import com.mjakobczyk.user.skills.model.dto.SkillDTO;
import com.mjakobczyk.user.skills.model.dto.SkillNewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Value("${resources.skills}")
    private String createSkillResource;

    @Value("${resources.skills}")
    private String getAllSkillsResource;

    @Autowired
    private RestTemplate restTemplate;

    public SkillNewDTO createSkill(@Valid SkillNewDTO skillNewDTO) {
        return restTemplate.postForObject(createSkillResource, skillNewDTO, SkillNewDTO.class);
    }

    public List<SkillDTO> getAllSkills() {
        return Arrays.stream(restTemplate.getForObject(getAllSkillsResource, SkillDTO[].class))
                .collect(Collectors.toList());
    }

}
