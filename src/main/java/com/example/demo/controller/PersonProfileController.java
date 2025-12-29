package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {
    private final PersonProfileService personService;

    public PersonProfileController(PersonProfileService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile person) {
        PersonProfile created = personService.createPerson(person);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getById(@PathVariable Long id) {
        PersonProfile person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAll() {
        List<PersonProfile> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/lookup/{referenceId}")
    public ResponseEntity<PersonProfile> lookup(@PathVariable String referenceId) {
        Optional<PersonProfile> person = personService.findByReferenceId(referenceId);
        return person.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/relationship-declared")
    public ResponseEntity<PersonProfile> updateRelationshipDeclared(@PathVariable Long id, @RequestParam boolean declared) {
        PersonProfile updated = personService.updateRelationshipDeclared(id, declared);
        return ResponseEntity.ok(updated);
    }
}