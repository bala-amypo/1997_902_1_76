package com.example.demo.Service.Implement;


import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonProfileServiceImplement {

    private final PersonProfileRepository personProfileRepository;

    public PersonProfileServiceImplement(PersonProfileRepository personProfileRepository) {
        this.personProfileRepository = personProfileRepository;
    }

    public PersonProfile createPerson(PersonProfile person) {
        if (personProfileRepository.findByEmail(person.getEmail()).isPresent()) {
            throw new ApiException("Duplicate email");
        }
        if (personProfileRepository.findByReferenceId(person.getReferenceId()).isPresent()) {
            throw new ApiException("Duplicate reference");
        }
        return personProfileRepository.save(person);
    }

    public PersonProfile getPersonById(Long id) {
        return personProfileRepository.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    public List<PersonProfile> getAllPersons() {
        return personProfileRepository.findAll();
    }

    public PersonProfile findByReferenceId(String referenceId) {
        return personProfileRepository.findByReferenceId(referenceId)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile person = getPersonById(id);
        person.setRelationshipDeclared(declared);
        return personProfileRepository.save(person);
    }
}
