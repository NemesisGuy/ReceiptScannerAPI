package za.co.vsoftsystems.factory;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: ReceiptDataFactory.java
* Description: This is the ReceiptDataFactory class
*
* */
import za.co.vsoftsystems.domain.ReceiptData;

public class ReceiptDataFactory {

    public static ReceiptData createReceiptData(int id, String centerName, String name, String vfsReference,
                                                String visaCategory, String subcategory, String subtype) {
        return new ReceiptData.Builder()
                .id(id)
                .centerName(centerName)
                .name(name)
                .vfsReference(vfsReference)
                .visaCategory(visaCategory)
                .subcategory(subcategory)
                .subtype(subtype)
                .build();
    }
    public static ReceiptData createReceiptData(ReceiptData receiptData) {
        return new ReceiptData.Builder()
                .id(receiptData.getId())
                .centerName(receiptData.getCenterName())
                .name(receiptData.getName())
                .vfsReference(receiptData.getVfsReference())
                .visaCategory(receiptData.getVisaCategory())
                .subcategory(receiptData.getSubcategory())
                .subtype(receiptData.getSubtype())
                .build();


    }
}
