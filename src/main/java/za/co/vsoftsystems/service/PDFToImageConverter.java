package za.co.vsoftsystems.service;
/*
* Author: Peter Buckingham
* File: PDFToImageConverter.java
* Description: This is the PDFToImageConverter class
* This class will not be used in the final product!!!
* */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class PDFToImageConverter {
    public static List<String> convertPDFToImages(String pdfFilePath) {
        List<String> imagePaths = new ArrayList<>();

        try {
            PDDocument document = PDDocument.load(new File(pdfFilePath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            for (int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300);
                String imagePath = "page-" + (page + 1) + ".png";
                ImageIO.write(bim, "png", new File(imagePath));
                imagePaths.add(imagePath);
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imagePaths;
    }
}
