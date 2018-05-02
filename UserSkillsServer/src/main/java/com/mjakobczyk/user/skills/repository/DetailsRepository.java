package com.mjakobczyk.user.skills.repository;

import com.mjakobczyk.user.skills.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetailsRepository extends JpaRepository <Details, UUID>{
}
