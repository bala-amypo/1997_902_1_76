package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl {

    private final RelationshipDeclarationRepository repository;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repository) {
        this.repository = repository;
    }

    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {
        return repository.save(declaration);
    }

    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return repository.findByPersonId(personId);
    }

    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration declaration = repository.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));

        declaration.setIsVerified(verified);
        return repository.save(declaration);
    }

    public List<RelationshipDeclaration> getAllDeclarations() {
        return repository.findAll();
    }
}
