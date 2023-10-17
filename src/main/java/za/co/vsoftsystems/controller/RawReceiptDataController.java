package za.co.vsoftsystems.controller;
/**
* Author: Peter Buckingham
* File: RawReceiptDataController.java
* Description: This is the RawReceiptDataController class
* This class will be used to store the raw data from the files and move the files to the processed folder
* Example of how to call the endpoint:
* http://localhost:port/store/raw/data/files
*
* */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.vsoftsystems.domain.RawReceiptData;
import za.co.vsoftsystems.service.RawReceiptDataService;

import java.util.List;

@RestController
@RequestMapping("/store/raw/data")
public class RawReceiptDataController {
    @Value("${fileprocessor.inputdir}")
    private String inputDir;

    @Value("${fileprocessor.outputdir}")
    private String outputDir;

    @Autowired
    private RawReceiptDataService rawReceiptDataService;

    //this endpoint will be used to store the raw data from the files and move the files to the processed folder
    @GetMapping("/files")
    public List<RawReceiptData> processFiles() {

        return rawReceiptDataService.processFiles(inputDir);
    }
}
