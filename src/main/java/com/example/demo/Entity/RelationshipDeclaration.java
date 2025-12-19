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
        return Personid;
    }
    public void setPersonId(Long personId){
        this.personId=personId;
    }
    public
    public String getRelationshipType(){
        return relationshipType;
    }
    public void setRelationshipType(String personType){
        this.relationshipType=relationshipType;
    }
    public String getReferenceId(){
        return referenceId;
    }
    public void setReferenceId(){
        this.referenceId=referenceId;
    }
    public String getFullName(){
        return fullname;
    }
    public void setFullName(String fullname){
        this.fullname=fullname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String Email){
        this.email=email;
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
    public Boolean getRelationshipDeclared(){
        return relationshipDeclared;
    }
    public void setRelationshipDeclared(Boolean relationshipDeclared){
        this.relationshipDeclared=relationshipDeclared;
    }
    public LocalDatetime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDatetime createdAt){
        this.createdAt=createdAt;
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