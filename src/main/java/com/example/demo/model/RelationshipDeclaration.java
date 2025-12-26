package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;
    private LocalDateTime declaredAt;

    private boolean verified;

    public RelationshipDeclaration() {
        this.declaredAt = LocalDateTime.now();
        this.verified = false;
    }

    public RelationshipDeclaration(Long personId,
         String relatedPersonName,
      String relationshipType,
       String description) {
        this.personId = personId;
        this.relatedPersonName = relatedPersonName;
        this.relationshipType = relationshipType;
        this.description = description;
        this.declaredAt = LocalDateTime.now();
        this.verified = false;
    }

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getRelatedPersonName() {
        return relatedPersonName;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeclaredAt() {
        return declaredAt;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
