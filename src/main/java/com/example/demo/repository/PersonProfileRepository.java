package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PersonProfile;

public interface PersonProfileRepository
        extends JpaRepository<PersonProfile, Long> {
}
