package com.example.demo.Controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-cases")
@Tag(name = "Conflict Cases")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictCase createCase(@RequestBody ConflictCase conflictCase) {
        return service.createCase(conflictCase);
    }

    @PutMapping("/{id}/status")
    public ConflictCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> getCasesByPerson(
            @PathVariable Long personId) {
        return service.getCasesByPerson(personId);
    }

    @GetMapping("/{id}")
    public ConflictCase getCaseById(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping
    public List<ConflictCase> getAllCases() {
        return service.getAllCases();
    }
}
