package za.co.vsoftsystems.service;
/*
* Author: Peter Buckingham
* File: RawReceiptDataService.java
* Description: This is the RawReceiptDataService class
* This class is used to store the raw data from the files and move the files to the processed folder
* */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.RawReceiptData;
import za.co.vsoftsystems.factory.RawReceiptDataFactory;
import za.co.vsoftsystems.repository.RawReceiptDataRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class RawReceiptDataService {

    @Autowired
    private RawReceiptDataRepository rawReceiptDataRepository;

    private String folderPath = "src/main/java/za/co/vsoftsystems/testdata/inputdata";
    private String processedFolderPath = "src/main/java/za/co/vsoftsystems/testdata/outputdata/processeddata";

    public List<RawReceiptData> processFiles(String folderPath) {
        List<RawReceiptData> rawReceiptDataList = new ArrayList<>();
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try {
                        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                        for (String line : lines) {
                            String fileName = file.getName(); // Get the file name
                           // RawReceiptData receiptData = RawReceiptDataFactory.createRawReceiptData(fileName, line); // Use factory method
                            RawReceiptData receiptData = new RawReceiptData(fileName, line  );
                            rawReceiptDataRepository.save(receiptData);
                            rawReceiptDataList.add(receiptData);
                        }
                        moveFileToProcessedFolder(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No files found in the folder: " + folderPath);
            }
        } else {
            System.out.println("The path provided is not a folder: " + folderPath);
        }

        return rawReceiptDataList;
    }

    private void moveFileToProcessedFolder(File file) throws IOException {
        Path sourcePath = file.toPath();
        Path destinationPath = Paths.get(processedFolderPath, file.getName());
        Files.move(sourcePath, destinationPath);
        System.out.println("File Saved to Database and moved to processed folder: " + destinationPath);
    }
}

/*@Service
public class RawReceiptDataService {

    @Autowired
    private RawReceiptDataRepository rawReceiptDataRepository;

    private String folderPath = "src/main/java/za/co/vsoftsystems/testdata/inputdata";
    private String processedFolderPath = "src/main/java/za/co/vsoftsystems/testdata/outputdata/processeddata";

    public List<RawReceiptData> processFiles(String folderPath) {
        List<RawReceiptData> rawReceiptDataList = new ArrayList<>();
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try {
                        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                        for (String line : lines) {
                            RawReceiptData receiptData = new RawReceiptData();
                            receiptData.setRawData(line);
                            rawReceiptDataRepository.save(receiptData);
                            rawReceiptDataList.add(receiptData);
                        }
                        moveFileToProcessedFolder(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                System.out.println("No files found in the folder: " + folderPath);
            }
        }else {
            System.out.println("The path provided is not a folder: " + folderPath);
        }

        return rawReceiptDataList;
    }

    private void moveFileToProcessedFolder(File file) throws IOException {
        Path sourcePath = file.toPath();
        Path destinationPath = Paths.get(processedFolderPath, file.getName());
        Files.move(sourcePath, destinationPath);
        System.out.println("File Saved to Database and moved to processed folder: " + destinationPath);
    }
}*/
