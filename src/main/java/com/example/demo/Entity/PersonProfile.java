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
    private Boolean relationshipeDeclared;
    private LocalDatetime declaredAt;
    private Boolean isVerified;

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
        this.fullname=fullname
    }
}