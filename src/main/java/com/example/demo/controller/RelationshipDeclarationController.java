package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {
    private final RelationshipDeclarationService relationshipService;

    public RelationshipDeclarationController(RelationshipDeclarationService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping
    public ResponseEntity<RelationshipDeclaration> create(@RequestBody RelationshipDeclaration declaration) {
        RelationshipDeclaration created = relationshipService.declareRelationship(declaration);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<RelationshipDeclaration>> getByPerson(@PathVariable Long personId) {
        List<RelationshipDeclaration> declarations = relationshipService.getDeclarationsByPerson(personId);
        return ResponseEntity.ok(declarations);
    }

    @PutMapping("/{id}/verify")
    public ResponseEntity<RelationshipDeclaration> verify(@PathVariable Long id, @RequestParam boolean verified) {
        RelationshipDeclaration updated = relationshipService.verifyDeclaration(id, verified);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAll() {
        List<RelationshipDeclaration> declarations = relationshipService.getAllDeclarations();
        return ResponseEntity.ok(declarations);
    }
}