package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relationship_declaration")
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long personId;

    @Column(nullable = false)
    private String relatedPersonName;

    @Column(nullable = false)
    private String relationshipType;

    @Column(length = 500)
    private String description;

    private LocalDateTime declaredAt;

    @Column(nullable = false)
    private boolean verified;

    // 🔹 JPA requires a no-arg constructor
    public RelationshipDeclaration() {
        this.declaredAt = LocalDateTime.now();
        this.verified = false;
    }

    public RelationshipDeclaration(
            Long personId,
            String relatedPersonName,
            String relationshipType,
            String description
    ) {
        this.personId = personId;
        this.relatedPersonName = relatedPersonName;
        this.relationshipType = relationshipType;
        this.description = description;
        this.declaredAt = LocalDateTime.now();
        this.verified = false;
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getRelatedPersonName() {
        return relatedPersonName;
    }

    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeclaredAt() {
        return declaredAt;
    }

    public void setDeclaredAt(LocalDateTime declaredAt) {
        this.declaredAt = declaredAt;
    }

    // ✅ Boolean field done CORRECTLY
    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
