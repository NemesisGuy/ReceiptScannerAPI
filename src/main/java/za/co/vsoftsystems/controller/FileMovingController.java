package za.co.vsoftsystems.controller;

/**
 * Author: Peter Buckingham
 * File: FileMovingController.java
 * Description: This is the FileMovingController class
 * This class is used to move the files from the input folder to the processed folder
 * The paths are configured in the application.properties file
 * Example of how to call the endpoint:
 * http://localhost:9000/move/files*
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.vsoftsystems.service.FileMovingService;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/move")
public class FileMovingController {

    @Autowired
    private FileMovingService fileMovingService;
    @Value("${fileprocessor.inputdir}")
    private String inputDir;

    @Value("${fileprocessor.outputdir}")
    private String processedDir;

    //this endpoint will be used to move the files from the input folder to the processed folder
    @GetMapping("/files")
    public void moveFiles() {
        File folder = new File(inputDir);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try {
                        fileMovingService.moveFileToProcessedFolder(file);
                        // System.out.print("file moved to processed folder");

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
    }
}