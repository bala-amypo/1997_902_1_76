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
    private LocalDateTime declaredAt;
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
    public LocalDateTime getDeclaredAt(){
        return declaredAt;
    }
    public void setDeclaredAt(LocalDateTime declaredAt){
        this.declaredAt=declaredAt;
    }
    public Boolean getIsVerified(){
        return isVerified;
    }
    public void setIsVerified(Boolean isVerified){
        this.isVerified=isVerified;
    }
    }
    public PersonProfile(Long id,Long personId,String relatedPersonName,String relationshipType,String description, LocaldateTime declaredAt, Boolean isVerified){

    
        this.id=id;
        this.personId=personId;
        this.relatedPersonName=relatedPersonName;
        this.relationshipType=relationshipType;
        this.description=description;
        this.declaredAt=declaredAt;
        this.isVerified=isVerified;
        
    }
    public RelationshipDeclaration(){

    }
}