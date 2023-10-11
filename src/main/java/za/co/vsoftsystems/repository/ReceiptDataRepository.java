package za.co.vsoftsystems.repository;
/**
* Author: Peter Buckingham (220165289)
* File: ReceiptDataRepository.java
* Description: This is the ReceiptDataRepository interface
* This interface is used to store the extracted data from the files
*
* */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.vsoftsystems.domain.ReceiptData;

@Repository
public interface ReceiptDataRepository extends JpaRepository<ReceiptData, Long> {


}
