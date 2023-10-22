package com.example.userservicepasswordmanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Session> userSessions;
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
    }
}
