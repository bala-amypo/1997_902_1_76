package com.example.demo.service.impl;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    @Autowired
    private PersonProfileRepository repository;

    @Override
    public PersonProfile createProfile(PersonProfile person) {
        return repository.save(person);
    }

    @Override
    public PersonProfile findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PersonProfile findByReferenceId(String referenceId) {
        return repository.findByReferenceId(referenceId);
    }

    @Override
    public List<PersonProfile> getAllProfiles() {
        return repository.findAll();
    }
}
