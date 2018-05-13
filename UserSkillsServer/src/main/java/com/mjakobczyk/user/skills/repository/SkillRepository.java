package com.mjakobczyk.user.skills.repository;

import com.mjakobczyk.user.skills.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
