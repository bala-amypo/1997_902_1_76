package com.example.demo.Controller;

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
    public ConflictFlag addFlag(@RequestBody ConflictFlag flag) {
        return service.addFlag(flag);
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> getFlagsByCase(
            @PathVariable Long caseId) {
        return service.getFlagsByCase(caseId);
    }

    @GetMapping("/{id}")
    public ConflictFlag getFlagById(@PathVariable Long id) {
        return service.getFlagById(id);
    }

    @GetMapping
    public List<ConflictFlag> getAllFlags() {
        return service.getAllFlags();
    }
}
