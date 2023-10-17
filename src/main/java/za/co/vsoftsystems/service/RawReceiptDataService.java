package za.co.vsoftsystems.service;
/**
* Author: Peter Buckingham
* File: RawReceiptDataService.java
* Description: This is the RawReceiptDataService class
* This class is used to store the raw data from the files and move the files to the processed folder
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.RawReceiptData;
import za.co.vsoftsystems.repository.RawReceiptDataRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class RawReceiptDataService {

    @Autowired
    private RawReceiptDataRepository rawReceiptDataRepository;


    @Value("${fileprocessor.inputdir}")
    private String inputDir;

    @Value("${fileprocessor.outputdir}")
    private String processedDir;

    public List<RawReceiptData> processFiles(String inputDir) {
        List<RawReceiptData> rawReceiptDataList = new ArrayList<>();
        File folder = new File(inputDir);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try {
                        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                        String fileName = file.getName(); // Get the file name
                        StringBuilder content = new StringBuilder();
                        for (String line : lines) {
                            content.append(line).append("\n");
                        }
                        // RawReceiptData receiptData = RawReceiptDataFactory.createRawReceiptData(fileName, content.toString()); // Use factory method
                        RawReceiptData receiptData = new RawReceiptData(fileName, content.toString());
                        rawReceiptDataRepository.save(receiptData);
                        rawReceiptDataList.add(receiptData);

                        // Move the file outside the loop if needed
                        // moveFileToProcessedFolder(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No files found in the folder: " + inputDir);
            }
        } else {
            System.out.println("The path provided is not a folder: " + inputDir);
        }

        return rawReceiptDataList;
    }


}

