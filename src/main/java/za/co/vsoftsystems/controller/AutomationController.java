package za.co.vsoftsystems.controller;
/**
 * Author: Peter Buckingham
 * File: AutomationController.java
 * Description: This is the AutomationController class
 * This class will be used to store the raw data from the files in the database and perform regex on the data and store in database
 * Example of how to call the endpoint:
 * http://localhost:port/automation/process-and-apply-regex
 *
 * */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.vsoftsystems.domain.RawReceiptData;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.service.FileProcessorService;
import za.co.vsoftsystems.service.RawReceiptDataService;
import za.co.vsoftsystems.service.ReceiptDataService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/automation")
public class AutomationController {
    private static final Logger logger = LoggerFactory.getLogger(AutomationController.class);

    @Value("${fileprocessor.inputdir}")
    private String inputDir;

    @Value("${fileprocessor.outputdir}")//not used here but can be used to store the processed files
    private String outputDir;

    @Autowired
    private RawReceiptDataService rawReceiptDataService;

    @Autowired
    private FileProcessorService fileProcessorService;

    @Autowired
    private ReceiptDataService receiptDataService;

    @GetMapping("/process-and-apply-regex")
    public List<ReceiptData> processAndApplyRegex() {
        logger.info("Processing files in the input directory: " + inputDir);
        //get file and store raw data in database
        rawReceiptDataService.processFiles(inputDir);
        //process raw data and apply regex
        List<ReceiptData> receiptDataList = fileProcessorService.processFiles(inputDir);
        //save all processed data to database
        receiptDataService.saveAllReceiptData(receiptDataList);
        // Fetch all entries from the database
        List<ReceiptData> allReceiptData = receiptDataService.getAllReceiptData();
        //return all data in database

        return allReceiptData;
    }

}
