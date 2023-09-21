package za.co.vsoftsystems.service;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: FileProcessorService.java
* Description: This is the FileProcessorService class
*
* */


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileProcessorService {

    public void processFiles(String folderPath) {
        File folder = new File(folderPath);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    try {
                        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                        for (String line : lines) {
                            // Process each line of the file here
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

