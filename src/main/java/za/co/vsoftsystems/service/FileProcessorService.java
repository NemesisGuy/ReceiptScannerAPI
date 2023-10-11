package za.co.vsoftsystems.service;
/*
* Author: Peter Buckingham
* File: FileProcessorService.java
* Description: This is the FileProcessorService class
* This class is used to process the files, it calls the ReceiptRegexProcessor class to extract the data from the files
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileProcessorService {

    @Autowired
    private ReceiptRegexProcessor regexProcessor;

    private String folderPath = "src/main/java/za/co/vsoftsystems/testdata/inputdata";

    public List<ReceiptData> processFiles(String folderPath) {
        List<ReceiptData> receiptDataList = new ArrayList<>();

        File folder = new File(folderPath);

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
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return receiptDataList;
    }




}
