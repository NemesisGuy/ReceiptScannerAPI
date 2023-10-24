package za.co.vsoftsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.vsoftsystems.domain.VFSReceiptData;

public interface VFSReceiptDataRepository extends JpaRepository<VFSReceiptData, Integer> {
    // Add custom queries or methods if needed
}

