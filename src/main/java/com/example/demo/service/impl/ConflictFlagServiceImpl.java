@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    @Autowired
    private ConflictFlagRepository repository;

    @Override
    public ConflictFlag createFlag(ConflictFlag flag) {
        return repository.save(flag);
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return repository.findByCaseId(caseId);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return repository.findAll();
    }
}
