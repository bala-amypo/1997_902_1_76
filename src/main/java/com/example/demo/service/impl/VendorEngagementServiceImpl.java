@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    @Autowired
    private VendorEngagementRepository repository;

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
        return repository.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return repository.findAll();
    }
}
