package com.example.demo.service.impl;

import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository repository;

    public ConflictFlagServiceImpl(ConflictFlagRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConflictFlag createFlag(ConflictFlag conflictFlag) {
        return repository.save(conflictFlag);
    }

    @Override
    public ConflictFlag updateFlagStatus(Long id, String status) {
        ConflictFlag flag = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flag not found"));
        flag.setStatus(status);
        return repository.save(flag);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flag not found"));
    }

    @Override
    public List<ConflictFlag> getFlagsByCaseId(Long caseId) {
        return repository.findByCaseId(caseId);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return repository.findAll();
    }
}
