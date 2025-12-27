package com.example.demo.service;

import com.example.demo.model.ConflictFlag;
import java.util.List;

public interface ConflictFlagService {

    ConflictFlag createFlag(ConflictFlag conflictFlag);

    ConflictFlag updateFlagStatus(Long id, String status);

    ConflictFlag getFlagById(Long id);

    List<ConflictFlag> getFlagsByCaseId(Long caseId);

    List<ConflictFlag> getAllFlags();
}
