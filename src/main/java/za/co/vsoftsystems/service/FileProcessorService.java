package za.co.vsoftsystems.service;
/**
* Author: Peter Buckingham
* File: FileProcessorService.java
* Description: This is the FileProcessorService class
* This class is used to process the files, it calls the ReceiptRegexProcessor class to extract the data from the files
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class FileProcessorService {
    private static final Logger logger = LoggerFactory.getLogger(FileProcessorService.class);
    @Autowired
    private ReceiptRegexProcessor regexProcessor;

    @Value("${fileprocessor.inputdir}")
    private String inputDir;

    public List<ReceiptData> processFiles(String inputDir) {
        List<ReceiptData> receiptDataList = new ArrayList<>();

        File folder = new File(inputDir);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    try {
                        byte[] fileContentBytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
                        String fileContent = new String(fileContentBytes);

                        // Use regexProcessor to extract receipt data from the entire file content
                        ReceiptData receiptData = regexProcessor.extractReceiptData(fileContent);

                        if (receiptData != null) {
                            String fileName = file.getName(); // Get the file name separately
                            receiptData.setFileName(fileName); // Set the fileName here
                            receiptDataList.add(receiptData);
                            logger.info("File processed by regex: " + file.getName());
                        }else {
                            logger.error("Error processing file for regex: " + file.getName());
                        }
                    } catch (IOException e) {
                        logger.error("Error processing file for regex: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }

        return receiptDataList;
    }




}
