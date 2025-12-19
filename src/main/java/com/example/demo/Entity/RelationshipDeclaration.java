package com.example.demo.Entity;
import jakarta.persistence.*;
import java.time.*;
@Entity
public class RelationshipDeclaration{
    @Id
    private Long id;
    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;
    private LocalDatetime declaredAt;
    private Boolean isVerified;
   
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getPersonId(){
        return personid;
    }
    public void setPersonId(Long personId){
        this.personId=personId;
    }
    public String getRelatedPersonName(){
          return relatedPersonName;
    }
    public void setRelatedPersonName(String relatedPersonName){
        this.relatedPersonName=relatedPersonName;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public Boolean getCreatedAt(){
        return createdAt;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String Department){
        this.department=department;
    }
    public LocalDatetime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDatetime createdAt){
        this.createdAt=createdAt;
    }
    public Boolean getRelationshipDeclared(){
        return relationshipDeclared;
    }
    public void setRelationshipDeclared(Boolean relationshipDeclared){
        this.relationshipDeclared=relationshipDeclared;
    }
   
    }
    public PersonProfile(Long id,String personType,String referenceId,String fullName,String email,String department,Boolean relationshipDeclared,LocateDatetime createdAt){
        this.id=id;
        this.personType=personType;
        this.referenceId=referenceId;
        this.fullName=fullName;
        this.email=email;
        this.department=department;
        this.relationshipDeclared=relationshipDeclared;
        this.isVerified=isVerified;
    }
    public PersonProfile(){

    }
}