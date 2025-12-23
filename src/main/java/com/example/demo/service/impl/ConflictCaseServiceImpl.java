package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictCaseServiceImpl {

    private final ConflictCaseRepository repository;

    public ConflictCaseServiceImpl(ConflictCaseRepository repository) {
        this.repository = repository;
    }

    public ConflictCase createCase(ConflictCase conflictCase) {
        return repository.save(conflictCase);
    }

    public ConflictCase updateCaseStatus(Long caseId, String status) {
        ConflictCase conflictCase = repository.findById(caseId)
                .orElseThrow(() -> new ApiException("case not found"));

        conflictCase.setStatus(status);
        return repository.save(conflictCase);
    }

    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repository.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    public ConflictCase getCaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException("case not found"));
    }

    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }
}
