package za.co.vsoftsystems.service;
/**
* Author: Peter Buckingham
* File: OCRService.java
* Description: This is the OCRService class
* This class will not be used in the final product!!!
* */
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OCRService {

    private final ITesseract tesseract;

    public OCRService() {
        tesseract = new Tesseract();
        tesseract.setDatapath("src/main/java/za/co/vsoftsystems/testdata/tesseractdata/");
        tesseract.setLanguage("eng");
    }

    public String doOCR(File imageFile) throws TesseractException {
        return tesseract.doOCR(imageFile);
    }
}
