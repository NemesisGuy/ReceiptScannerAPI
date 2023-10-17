package za.co.vsoftsystems.controller;
/**
 * Author: Peter Buckingham
 * File: FileProcessorController.java
 * Description: This is the FileProcessorController class
 * This class is used to process the files in the inputdata folder and save the data to the database after regex processing,
 * and return the data in json format to the browser
 * The path to the inputdata folder is set in the application.properties file
 * Example of how to call the endpoint:
 * http://localhost:9000/process/files/default/regex
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

@RestController
@RequestMapping("/process")
public class FileProcessorController {

    private final String defaultFolderPath = "src/main/java/za/co/vsoftsystems/testdata/inputdata"; // Set your default folder path here
    @Value("${fileprocessor.inputdir}")
    private String inputDir;
    @Autowired
    private FileProcessorService fileProcessorService;

    @Autowired
    private ReceiptDataService receiptDataService;


    //this calls the service to process the regex on the files and save them to the database and returns all the data in the database to the browser in json format
    //http://localhost:9000/process/files/default/regex
    @GetMapping("/files/default/regex")
    public List<ReceiptData> processFilesWithDefaultPath() {
        List<ReceiptData> receiptDataList = fileProcessorService.processFiles(inputDir);
        receiptDataService.saveAllReceiptData(receiptDataList);

        // Fetch all entries from the database
        List<ReceiptData> allReceiptData = receiptDataService.getAllReceiptData();

        return allReceiptData;
    }

    @GetMapping("/error")
    public String handleCustomException(Exception ex, Model model) {
        // error handling code
        return "error"; // Check that "error" is a valid logical view name
    }
}
