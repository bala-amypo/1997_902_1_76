package com.example.demo.Service.Implement;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictFlagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictFlagServiceImplement {

    private final ConflictFlagRepository repository;

    public ConflictFlagServiceImplement(ConflictFlagRepository repository) {
        this.repository = repository;
    }

    public ConflictFlag addFlag(ConflictFlag flag) {
        return repository.save(flag);
    }

    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return repository.findByCaseId(caseId);
    }

    public ConflictFlag getFlagById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException("flag not found"));
    }

    public List<ConflictFlag> getAllFlags() {
        return repository.findAll();
    }
}
