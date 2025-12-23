package com.example.demo.service;

import com.example.demo.model.ConflictCase;
import java.util.List;

public interface ConflictCaseService {

    ConflictCase create(ConflictCase conflictCase);

    List<ConflictCase> findByPrimaryOrSecondary(Long id1, Long id2);
}
