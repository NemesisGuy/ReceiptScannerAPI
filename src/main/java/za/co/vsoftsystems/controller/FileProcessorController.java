package za.co.vsoftsystems.controller;
/**
 * Author: Peter Buckingham
 * File: FileProcessorController.java
 * Description: This is the FileProcessorController class
 * This class is used to process the files in the inputdata folder and save the data to the database after regex processing,
 * and return the data in json format to the browser
 * The path to the inputdata folder is set in the application.properties file
 * Example of how to call the endpoint:
 * http://localhost:port/process/files/default/regex
*
*
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.service.FileProcessorService;
import za.co.vsoftsystems.service.ReceiptDataService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/process")
public class FileProcessorController {
    private static final Logger logger = LoggerFactory.getLogger(FileProcessorController.class);


    // Set your default folder path in the application.properties file
    @Value("${fileprocessor.inputdir}")
    private String inputDir;
    @Autowired
    private FileProcessorService fileProcessorService;

    @Autowired
    private ReceiptDataService receiptDataService;

    //this calls the service to process the regex on the files and save them to the database and returns all the data in the database to the browser in json format
    //http://localhost:port/process/files/default/regex
    @GetMapping("/files/default/regex")
    public List<ReceiptData> processFilesWithDefaultPath() {
        logger.info("Processing files in the input directory: " + inputDir);
        List<ReceiptData> receiptDataList = fileProcessorService.processFiles(inputDir);
        receiptDataService.saveAllReceiptData(receiptDataList);

        // Fetch all entries from the database
        List<ReceiptData> allReceiptData = receiptDataService.getAllReceiptData();


        return allReceiptData;
    }

    @GetMapping("/error")
    public String handleCustomException(Exception ex, Model model) {
        logger.error("Error processing files in the input directory: " + inputDir);
        // error handling code
        return "error"; // Check that "error" is a valid logical view name
    }
}
