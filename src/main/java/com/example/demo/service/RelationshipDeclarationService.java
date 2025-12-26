public interface RelationshipDeclarationService {

    RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration);

    List<RelationshipDeclaration> getDeclarationsByPerson(Long personId);

    RelationshipDeclaration verifyDeclaration(Long id, boolean verified);

    List<RelationshipDeclaration> getAllDeclarations();
}
