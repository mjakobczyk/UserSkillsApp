package com.mjakobczyk.user.skills.model.dto;

import java.util.UUID;

public class UserDTO {

    private UUID id;

    private String email;

    private String name;

    private UUID password;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getPassword() {
        return password;
    }

    public void setPassword(UUID password) {
        this.password = password;
    }
}
