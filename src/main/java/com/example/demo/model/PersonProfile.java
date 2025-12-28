package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PersonProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String referenceId;

    private String fullName;
    private String email;
    private LocalDateTime createdAt;
    private boolean relationshipDeclared;

    public PersonProfile() {
        this.createdAt = LocalDateTime.now();
    }

    public PersonProfile(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isRelationshipDeclared() {
        return relationshipDeclared;
    }

    public void setRelationshipDeclared(boolean relationshipDeclared) {
        this.relationshipDeclared = relationshipDeclared;
    }
}
