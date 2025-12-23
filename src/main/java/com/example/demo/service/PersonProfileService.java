package com.example.demo.service;

import com.example.demo.model.PersonProfile;
import java.util.List;

public interface PersonProfileService {

    PersonProfile create(PersonProfile profile);

    PersonProfile getByEmail(String email);

    PersonProfile getByReferenceId(String refId);

    List<PersonProfile> getAll();
}
