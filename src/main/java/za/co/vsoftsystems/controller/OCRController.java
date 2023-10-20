package za.co.vsoftsystems.controller;
/**
* Author: Peter Buckingham
* File: OCRController.java
* Description: This is the OCRController class
* This class will be used to perform OCR on the images and pdfs, this will be used to extract the data from the images and pdfs
* NOTE not used in the final product!!!
*
*
* */

import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.vsoftsystems.service.ocr.OCRService;
import za.co.vsoftsystems.service.ocr.PDFToImageConverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OCRController {

    @Autowired
    private OCRService ocrService;
    @GetMapping("/performOCR")
    public ResponseEntity<?> performOCR() {
        try {
            File imageFile = new File("src/main/java/za/co/vsoftsystems/testdata/images/ocr.jpg");
            String ocrResult = ocrService.doOCR(imageFile);

            return ResponseEntity.ok(ocrResult);
        } catch (TesseractException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred during OCR processing.");
        }
    }
    @GetMapping("/performOCRPDF")
    public ResponseEntity<?> performOCRPDF() {
        try {
            String pdfFilePath = "src/main/java/za/co/vsoftsystems/testdata/pdf/Igor_Demchenko_VFS_Receipt.pdf";
            List<String> imagePaths = PDFToImageConverter.convertPDFToImages(pdfFilePath);

            List<String> ocrResults = new ArrayList<>();

            for (String imagePath : imagePaths) {
                File imageFile = new File(imagePath);
                String ocrResult = ocrService.doOCR(imageFile);
                ocrResults.add(ocrResult);
            }

            return ResponseEntity.ok(ocrResults);
        } catch (TesseractException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred during OCR processing.");
        }
    }
}
