package za.co.vsoftsystems.service;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: ReceiptRegexProcessor.java
* Description: This is the ReceiptRegexProcessor class
*
* */
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.factory.ReceiptDataFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReceiptRegexProcessor {


    public ReceiptData extractReceiptData(String text) {
        ReceiptData.Builder receipt = new ReceiptData.Builder();

        // Center/Location Name Extraction Pattern
        String centerNamePattern = "(\\b[\\w\\s]+(?=, Facilitation Visa and Permit))";
        Pattern centerNameRegex = Pattern.compile(centerNamePattern);

        // Name Extraction Pattern
        String namePattern = "(?:(?:Mr\\.|Ms\\.|Mrs\\.)\\s+(.*?)(?=\\s+(?:TRC|TRR|TRW|PRP|POP))|(?:(?<=\\s+(?:Mr\\.|Ms\\.|Mrs\\.))(.*?)(?=\\s+(?:TRC|TRR|TRW|PRP|POP)))";
        Pattern nameRegex = Pattern.compile(namePattern);

        // VFS Reference Pattern
        String vfsReferencePattern = "\\b(?:TRC|TRR|TRW|PRP|POP)([A-Z\\d]+)";
        Pattern vfsReferenceRegex = Pattern.compile(vfsReferencePattern);

        // Visa Category Extraction Pattern
        String visaCategoryPattern = "Visa Category:\\s*(.+)";
        Pattern visaCategoryRegex = Pattern.compile(visaCategoryPattern);

        // Subcategory Extraction Pattern
        String subcategoryPattern = "Sub\\s*Visa\\s*Category\\s*[:,]\\s*(.+)";
        Pattern subcategoryRegex = Pattern.compile(subcategoryPattern);

        // Subtype Extraction Pattern
        String subtypePattern = "Sub\\s*Type\\s*Category\\s*[:,]\\s*(.+)";
        Pattern subtypeRegex = Pattern.compile(subtypePattern);

        // Extract Center/Location Name
        Matcher centerNameMatcher = centerNameRegex.matcher(text);
        if (centerNameMatcher.find()) {
            String centerName = centerNameMatcher.group(1).trim();
            receipt.centerName(centerName);
        }

        // Extract Name
        Matcher nameMatcher = nameRegex.matcher(text);
        if (nameMatcher.find()) {
            String name = nameMatcher.group(1) != null ? nameMatcher.group(1).trim() : nameMatcher.group(2).trim();
            receipt.name(name);
        }

        // Extract VFS Reference
        Matcher vfsReferenceMatcher = vfsReferenceRegex.matcher(text);
        if (vfsReferenceMatcher.find()) {
            String vfsReference = vfsReferenceMatcher.group(1);
            receipt.vfsReference(vfsReference);
        }

        // Extract Visa Category
        Matcher visaCategoryMatcher = visaCategoryRegex.matcher(text);
        if (visaCategoryMatcher.find()) {
            String visaCategory = visaCategoryMatcher.group(1);
            receipt.visaCategory(visaCategory);
        }

        // Extract Subcategory
        Matcher subcategoryMatcher = subcategoryRegex.matcher(text);
        if (subcategoryMatcher.find()) {
            String subcategory = subcategoryMatcher.group(1);
            receipt.subcategory(subcategory);
        }

        // Extract Subtype
        Matcher subtypeMatcher = subtypeRegex.matcher(text);
        if (subtypeMatcher.find()) {
            String subtype = subtypeMatcher.group(1);
            receipt.subtype(subtype);
        }

        // Use the factory to create ReceiptData
        return ReceiptDataFactory.createReceiptData(receipt.build());
    }
}

