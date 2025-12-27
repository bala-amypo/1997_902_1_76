package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflicts")
public class ConflictCaseController {

    private final ConflictCaseService conflictCaseService;

    public ConflictCaseController(ConflictCaseService conflictCaseService) {
        this.conflictCaseService = conflictCaseService;
    }
}
