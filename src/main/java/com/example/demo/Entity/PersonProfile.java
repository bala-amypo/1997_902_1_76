package com.example.demo.Entity;
import jakarta.persistence.*;
import java.time.*;
@Entity
public class PersonProfile{
    @Id
    private long id;
    private String personType;
    private String referenceld;
    private String fullname;
    private String email;
    private String department;
    private Boolean relationshipDeclared;
    private LocalDatetime createdAt;
   

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getPersonType(){
        return personType;
    }
    public void setPersonType(String personType){
        this.personId=personId;
    }
    public String getReferenceId(){
        return referenceId;
    }
    public void setReferenceId(){
        this.referenceId=referenceId;
    }
    public String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname){
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
    public Boolean getrelationshipDeclared(){
        return relationshipDeclared
    }
}