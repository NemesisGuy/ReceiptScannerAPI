package za.co.vsoftsystems.service;
/**
 * Author: Peter Buckingham (220165289)
 * Date: 20 Sep 2023
 * File: ReceiptDataService.java
 * Description: This is the ReceiptDataService class
 * This class is used to store the extracted data from the files
 *
* */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.repository.ReceiptDataRepository;

import java.util.List;


@Service
public class ReceiptDataService {

    @Autowired
    private ReceiptDataRepository receiptDataRepository;

    public void saveReceiptData(ReceiptData receiptData) {
        receiptDataRepository.save(receiptData);
    }

    public List<ReceiptData> getAllReceiptData() {
        return receiptDataRepository.findAll();
    }

    public void saveAllReceiptData(List<ReceiptData> receiptDataList) {
        receiptDataRepository.saveAll(receiptDataList);
    }
}
