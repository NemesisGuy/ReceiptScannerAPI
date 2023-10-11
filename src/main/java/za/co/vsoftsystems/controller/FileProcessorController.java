package za.co.vsoftsystems.controller;
/*
* Author: Peter Buckingham
* File: FileProcessorController.java
* Description: This is the FileProcessorController class
* This class is used to process the files in the inputdata folder and save the data to the database after regex processing,
* and return the data in json format to the browser
* Example of how to call the endpoint:
* http://localhost:9000/process/files/default/regex
*
*
* */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.service.FileProcessorService;
import za.co.vsoftsystems.service.ReceiptDataService;

@RestController
@RequestMapping("/process")
public class FileProcessorController {

    private final String defaultFolderPath = "src/main/java/za/co/vsoftsystems/testdata/inputdata"; // Set your default folder path here

    @Autowired
    private FileProcessorService fileProcessorService;

    @Autowired
    private ReceiptDataService receiptDataService;


/*
    @PostMapping("/files")
    public void processFiles(@RequestParam String folderPath) {
        List<ReceiptData> receiptDataList = fileProcessorService.processFiles(folderPath);
        receiptDataService.saveAllReceiptData(receiptDataList);
    }
*/

    //this calls the service to process the regex on the files and save them to the database and returns all the data in the database to the browser in json format
    //http://localhost:9000/process/files/default/regex
    @GetMapping("/files/default/regex")
    public List<ReceiptData> processFilesWithDefaultPath() {
        List<ReceiptData> receiptDataList = fileProcessorService.processFiles(defaultFolderPath);
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
