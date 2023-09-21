package za.co.vsoftsystems.service;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: ReceiptDataService.java
* Description: This is the ReceiptDataService class
*
* */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.repository.ReceiptDataRepository;

@Service
public class ReceiptDataService {
    @Autowired
    private ReceiptDataRepository repository;

    public void saveReceiptData(String value1, String value2) {
        repository.customInsert(value1, value2);
    }
}
