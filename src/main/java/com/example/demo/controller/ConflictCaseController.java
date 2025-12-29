package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conflict-cases")
public class ConflictCaseController {
    private final ConflictCaseService caseService;

    public ConflictCaseController(ConflictCaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public ResponseEntity<ConflictCase> create(@RequestBody ConflictCase conflictCase) {
        ConflictCase created = caseService.createCase(conflictCase);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ConflictCase> updateStatus(@PathVariable Long id, @RequestParam String status) {
        ConflictCase updated = caseService.updateCaseStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> getByPerson(@PathVariable Long personId) {
        List<ConflictCase> cases = caseService.getCasesByPerson(personId);
        return ResponseEntity.ok(cases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getById(@PathVariable Long id) {
        Optional<ConflictCase> conflictCase = caseService.getCaseById(id);
        return conflictCase.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAll() {
        List<ConflictCase> cases = caseService.getAllCases();
        return ResponseEntity.ok(cases);
    }
}
