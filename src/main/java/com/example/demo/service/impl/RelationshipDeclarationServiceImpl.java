@Service
public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    @Autowired
    private RelationshipDeclarationRepository repository;

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {
        return repository.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return repository.findByPersonId(personId);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration declaration =
                repository.findById(id).orElseThrow();
        declaration.setIsVerified(verified);
        return repository.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repository.findAll();
    }
}
