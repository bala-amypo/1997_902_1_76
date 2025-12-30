// package com.example.demo.controller;

// import com.example.demo.model.ConflictFlag;
// import com.example.demo.service.ConflictFlagService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/conflict-flags")
// public class ConflictFlagController {
//     private final ConflictFlagService flagService;

//     public ConflictFlagController(ConflictFlagService flagService) {
//         this.flagService = flagService;
//     }

//     @PostMapping
//     public ResponseEntity<ConflictFlag> create(@RequestBody ConflictFlag flag) {
//         ConflictFlag created = flagService.addFlag(flag);
//         return ResponseEntity.ok(created);
//     }

//     @GetMapping("/case/{caseId}")
//     public ResponseEntity<List<ConflictFlag>> getByCase(@PathVariable Long caseId) {
//         List<ConflictFlag> flags = flagService.getFlagsByCase(caseId);
//         return ResponseEntity.ok(flags);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
//         ConflictFlag flag = flagService.getFlagById(id);
//         return ResponseEntity.ok(flag);
//     }

//     @GetMapping
//     public ResponseEntity<List<ConflictFlag>> getAll() {
//         List<ConflictFlag> flags = flagService.getAllFlags();
//         return ResponseEntity.ok(flags);
//     }
// }








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









package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {
    private final VendorEngagementService engagementService;

    public VendorEngagementController(VendorEngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @PostMapping
    public ResponseEntity<VendorEngagementRecord> create(@RequestBody VendorEngagementRecord record) {
        VendorEngagementRecord created = engagementService.addEngagement(record);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByEmployee(@PathVariable Long employeeId) {
        List<VendorEngagementRecord> engagements = engagementService.getEngagementsByEmployee(employeeId);
        return ResponseEntity.ok(engagements);
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByVendor(@PathVariable Long vendorId) {
        List<VendorEngagementRecord> engagements = engagementService.getEngagementsByVendor(vendorId);
        return ResponseEntity.ok(engagements);
    }

    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAll() {
        List<VendorEngagementRecord> engagements = engagementService.getAllEngagements();
        return ResponseEntity.ok(engagements);
    }
}
