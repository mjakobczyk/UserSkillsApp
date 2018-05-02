package com.mjakobczyk.user.skills.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "skills")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"})
public class Skill {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    private UUID id;

    @NotNull
    @Size(max = 100)
    private String skillName;

    public Skill() {

    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
