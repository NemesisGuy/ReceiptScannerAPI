package za.co.vsoftsystems.service;

/*
 * Author: Peter Buckingham (220165289)
 * Date: 20 Sep 2023
 * File: ReceiptRegexProcessor.java
 * Description: This is the ReceiptRegexProcessor class
 * This class is used to extract the data from the files
 */

import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.factory.ReceiptDataFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReceiptRegexProcessor {

    public ReceiptData extractReceiptData(String text) {
        ReceiptData.Builder receipt = new ReceiptData.Builder();

       /* // Center/Location Name Extraction Pattern
        String centerNamePattern = "(\\b[\\w\\s]+(?=, Facilitation Visa and Permit))";
        Pattern centerNameRegex = Pattern.compile(centerNamePattern);*/
        // Center Name Extraction Pattern
        String centerNamePattern = "Centre,[\\s]*([^\\-]+)";
        Pattern centerNameRegex = Pattern.compile(centerNamePattern);


        // Name Extraction Pattern
        //String namePattern = "(?:Mr\\.\\s|Ms\\.\\s|Mrs\\.\\s)([^\\n]+)";
       // String namePattern = "(?:Mr\\.|Ms\\.|Mrs\\.)\\s+([A-Z]+)";
       // String namePattern = "(?:Mr\\.|Ms\\.|Mrs\\.)\\s+([A-Z]+(?:\\s+[A-Z]+){0,3})";
        String namePattern = "(?:Mr\\.|Ms\\.|Mrs\\.)\\s+([A-Z]+(?:\\s+[A-Z]+)*)\\s+(?:TRC|TRR|TRW|PRP|POP)";


        Pattern nameRegex = Pattern.compile(namePattern);

        // VFS Reference Pattern
      // String vfsReferencePattern = "\\b(?:TRC|TRR|TRW|PRP|POP)([A-Z\\d]+)";
        //String vfsReferencePattern = "\\b(?:TRC|TRR|TRW|PRP|POP)([A-Z]{3}\\d+)";
       // String vfsReferencePattern = "\\b(?:TRA|TRR|PRP|TRC|TRW|POP)\\d+";
        String vfsReferencePattern = "\\b(?:TRC|TRR|TRW|PRP|POP)\\S+(?=\\s)";


        Pattern vfsReferenceRegex = Pattern.compile(vfsReferencePattern);

        // Visa Category Extraction Pattern
        String visaCategoryPattern = "(?:Visa )?Category:?\\s*(.+)";
        Pattern visaCategoryRegex = Pattern.compile(visaCategoryPattern);

        // Subcategory Extraction Pattern
        String subcategoryPattern = "Sub VISA Category:\\s*(.+)";
        Pattern subcategoryRegex = Pattern.compile(subcategoryPattern);

        // Subtype Extraction Pattern
       // String subtypePattern = "Sub Type Category:\\s*(.+)";
       // String subtypePattern = "Sub Type Category:\\s*([^\\d\\n]+|\\d+\\([^)]+\\))";
        String subtypePattern = "Sub Type Category:\\s*([^\\d]+(?:\\(\\d+\\))?\\s*)";


        Pattern subtypeRegex = Pattern.compile(subtypePattern);

        // Extract Center/Location Name
        Matcher centerNameMatcher = centerNameRegex.matcher(text);
        if (centerNameMatcher.find()) {
            String centerName = centerNameMatcher.group(1).trim();
            receipt.centerName(centerName);
            System.out.println(centerName);
        } else {
            System.out.println("Center/Location Name Not found"); // Placeholder message
            receipt.centerName("Match Not found");
        }

        // Extract Name
        Matcher nameMatcher = nameRegex.matcher(text);
        if (nameMatcher.find()) {
            String name = nameMatcher.group(1) != null ? nameMatcher.group(1).trim() : nameMatcher.group(2).trim();
            receipt.name(name);
            System.out.println(name);
        } else {
            System.out.println("Name not found"); // Placeholder message
            receipt.name("Match Not found");
        }

        // Extract VFS Reference
        Matcher vfsReferenceMatcher = vfsReferenceRegex.matcher(text);
        if (vfsReferenceMatcher.find()) {
            String vfsReference = vfsReferenceMatcher.group(0);
            receipt.vfsReference(vfsReference.trim());
            receipt.vfsReference(vfsReference);
            System.out.println(vfsReference);
        } else {
            System.out.println("VFS Reference not found"); // Placeholder message
            receipt.vfsReference("Match Not found");
        }

        // Extract Visa Category
        Matcher visaCategoryMatcher = visaCategoryRegex.matcher(text);
        if (visaCategoryMatcher.find()) {
            String visaCategory = visaCategoryMatcher.group(1);
            receipt.visaCategory(visaCategory);
            System.out.println(visaCategory);
        } else {
            System.out.println("Visa Category not found"); // Placeholder message
            receipt.visaCategory("Match Not found");
        }

        // Extract Subcategory
        Matcher subcategoryMatcher = subcategoryRegex.matcher(text);
        if (subcategoryMatcher.find()) {
            String subcategory = subcategoryMatcher.group(1);
            receipt.subcategory(subcategory);
            System.out.println(subcategory);
        } else {
            System.out.println("Subcategory not found"); // Placeholder message
             receipt.subcategory("Match Not found");
        }

        // Extract Subtype
        Matcher subtypeMatcher = subtypeRegex.matcher(text);
        if (subtypeMatcher.find()) {
            String subtype = subtypeMatcher.group(1);
            receipt.subtype(subtype);
            System.out.println(subtype);
        } else {
            System.out.println("Subtype not found"); // Placeholder message
            receipt.subtype("Match Not found"); // Placeholder message
        }

        // Use the factory to create ReceiptData object
        ReceiptData receiptData = ReceiptDataFactory.createReceiptData(receipt.build());

        // Return the ReceiptData object
        return receiptData;
    }
}
