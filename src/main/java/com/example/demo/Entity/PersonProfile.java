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
    
}