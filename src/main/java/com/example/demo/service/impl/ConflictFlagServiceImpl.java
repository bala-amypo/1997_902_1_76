package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 🔥 VERY IMPORTANT
public class ConflictCaseServiceImpl implements{

    private final ConflictCaseRepository repository;

    public ConflictCaseServiceImpl(ConflictCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        return repository.save(conflictCase);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }

    @Override
    public ConflictCase getCaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));
    }
}
