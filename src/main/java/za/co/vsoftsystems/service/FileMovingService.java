package za.co.vsoftsystems.service;
/**
 * Author: Peter Buckingham (220165289)
 * File: FileMovingService.java
 * Description: This is the FileMovingService class
 * This class is used to move the files from the input folder to the processed folder
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileMovingService {

    @Value("${fileprocessor.inputdir}")
    private String inputDir;

    @Value("${fileprocessor.outputdir}")
    private String processedDir;

    public void moveFileToProcessedFolder(File file) throws IOException {
        Path sourcePath = file.toPath();
        Path destinationPath = Paths.get(processedDir, file.getName());
        Files.move(sourcePath, destinationPath);
        System.out.println("File Moved to processed folder: " + destinationPath);
    }
}
