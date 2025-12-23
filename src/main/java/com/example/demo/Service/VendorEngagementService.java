package com.example.demo.service;

import com.example.demo.model.VendorEngagementRecord;
import java.util.List;

public interface VendorEngagementService {

    VendorEngagementRecord create(VendorEngagementRecord record);

    List<VendorEngagementRecord> findByEmployeeId(Long id);

    List<VendorEngagementRecord> findByVendorId(Long id);
}
