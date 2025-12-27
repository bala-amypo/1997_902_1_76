package com.example.demo.service;

import com.example.demo.model.ConflictCase;
import java.util.List;

public interface ConflictCaseService {

    ConflictCase createCase(ConflictCase conflictCase);

    List<ConflictCase> getAllCases();

    ConflictCase getCaseById(Long id);
}
