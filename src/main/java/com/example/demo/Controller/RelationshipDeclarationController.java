package com.example.demo.Controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
@Tag(name = "Relationship Declarations")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration declareRelationship(
            @RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(
            @PathVariable Long personId) {
        return service.getDeclarationsByPerson(personId);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verifyDeclaration(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    @GetMapping
    public List<RelationshipDeclaration> getAllDeclarations() {
        return service.getAllDeclarations();
    }
}
