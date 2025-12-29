package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(AuthenticationManager authenticationManager,
                         CustomUserDetailsService userDetailsService,
                         JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        CustomUserDetailsService.UserRecord user = userDetailsService.register(
                request.getUsername(), request.getPassword(), "USER");
        
        UserPrincipal userPrincipal = new UserPrincipal(
                user.getId(), user.getUsername(), user.getPassword(), user.getRole());
        String token = tokenProvider.generateToken(userPrincipal);
        
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String token = tokenProvider.generateToken(userPrincipal);
        
        return ResponseEntity.ok(new AuthResponse(token, userPrincipal.getUsername(), userPrincipal.getRole()));
    }
}








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








package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conflict-flags")
public class ConflictFlagController {
    private final ConflictFlagService flagService;

    public ConflictFlagController(ConflictFlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping
    public ResponseEntity<ConflictFlag> create(@RequestBody ConflictFlag flag) {
        ConflictFlag created = flagService.addFlag(flag);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<ConflictFlag>> getByCase(@PathVariable Long caseId) {
        List<ConflictFlag> flags = flagService.getFlagsByCase(caseId);
        return ResponseEntity.ok(flags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
        ConflictFlag flag = flagService.getFlagById(id);
        return ResponseEntity.ok(flag);
    }

    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAll() {
        List<ConflictFlag> flags = flagService.getAllFlags();
        return ResponseEntity.ok(flags);
    }
}








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
