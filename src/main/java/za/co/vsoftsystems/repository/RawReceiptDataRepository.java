package za.co.vsoftsystems.repository;
/*
* Author: Peter Buckingham
* File: RawReceiptDataRepository.java
* Description: This is the RawReceiptDataRepository class
* This interface is used to store the raw data from the files
* */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.vsoftsystems.domain.RawReceiptData;

@Repository
public interface RawReceiptDataRepository extends JpaRepository<RawReceiptData, Long> {


}
