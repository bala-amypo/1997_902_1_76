package com.example.demo.service.impl;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import com.example.demo.exception.ApiException;

import java.util.List;

public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repository;

    public PersonProfileServiceImpl(PersonProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonProfile create(PersonProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<PersonProfile> getAll() {
        return repository.findAll();
    }
}
