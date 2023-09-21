package za.co.vsoftsystems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileProcessorService {

    @Autowired
    private ReceiptRegexProcessor regexProcessor;

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

                            // Use regexProcessor to extract receipt data
                            ReceiptData receiptData = regexProcessor.extractReceiptData(line);

                            // Now you can use receiptData for further processing or database insertion
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
