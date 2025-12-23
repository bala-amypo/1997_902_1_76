package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;
import java.util.List;

public interface RelationshipDeclarationService {

    RelationshipDeclaration create(RelationshipDeclaration declaration);

    List<RelationshipDeclaration> getAll();
}
