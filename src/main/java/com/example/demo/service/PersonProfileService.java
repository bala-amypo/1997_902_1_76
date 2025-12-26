package com.example.demo.service;

import com.example.demo.model.PersonProfile;
import java.util.List;

public interface PersonProfileService {

    PersonProfile createProfile(PersonProfile person);

    PersonProfile findById(Long id);

    PersonProfile findByReferenceId(String referenceId);

    List<PersonProfile> getAllProfiles();
}
