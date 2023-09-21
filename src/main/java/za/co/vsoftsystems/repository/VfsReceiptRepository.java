package za.co.vsoftsystems.repository;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: VfsReceiptRepository.java
* Description: This is the VfsReceiptRepository interface
*
* */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.vsoftsystems.domain.VfsReceiptEntity;

@Repository
public interface VfsReceiptRepository extends JpaRepository<VfsReceiptEntity, Long> {
    // You can add custom queries or methods if needed
}
