package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-flags")
@Tag(name = "Conflict Flags")
public class ConflictFlagController {

    private final ConflictFlagService service;

    public ConflictFlagController(ConflictFlagService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictFlag createFlag(@RequestBody ConflictFlag conflictFlag) {
        return service.createFlag(conflictFlag);   // ✅ FIXED
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> getFlagsByCaseId(@PathVariable Long caseId) {
        return service.getFlagsByCaseId(caseId);   // ✅ FIXED
    }

    @GetMapping("/{id}")
    public ConflictFlag getFlagById(@PathVariable Long id) {
        return service.getFlagById(id);
    }

    @PutMapping("/{id}/status")
    public ConflictFlag updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateFlagStatus(id, status);
    }

    @GetMapping
    public List<ConflictFlag> getAllFlags() {
        return service.getAllFlags();
    }
}
