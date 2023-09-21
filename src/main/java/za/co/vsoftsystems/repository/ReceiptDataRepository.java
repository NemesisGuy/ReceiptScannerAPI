package za.co.vsoftsystems.repository;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: ReceiptDataRepository.java
* Description: This is the ReceiptDataRepository interface
*
* */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.vsoftsystems.domain.ReceiptData;

@Repository
public interface ReceiptDataRepository extends JpaRepository<ReceiptData, Long> {

    @Modifying
    @Query(value = "INSERT INTO receipt_data (column1, column2) VALUES (:value1, :value2)", nativeQuery = true)
    void customInsert(@Param("value1") String value1, @Param("value2") String value2);
}
