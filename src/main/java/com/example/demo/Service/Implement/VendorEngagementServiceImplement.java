package com.example.demo.Service.Implement;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.VendorEngagementRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorEngagementServiceImplement {

    private final VendorEngagementRecordRepository repository;

    public VendorEngagementServiceImplement(VendorEngagementRecordRepository repository) {
        this.repository = repository;
    }

    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
        return repository.save(record);
    }

    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    public List<VendorEngagementRecord> getAllEngagements() {
        return repository.findAll();
    }
}
