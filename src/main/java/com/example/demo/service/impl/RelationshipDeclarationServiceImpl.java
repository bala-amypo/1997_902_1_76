package com.example.demo.service.impl;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    @Autowired
    private RelationshipDeclarationRepository repository;

    @Override
    public RelationshipDeclaration declareRelationship(
            RelationshipDeclaration declaration) {
        return repository.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return repository.findByPersonId(personId);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration declaration =
                repository.findById(id).orElseThrow();
        declaration.setVerified(verified);
        return repository.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repository.findAll();
    }
}
