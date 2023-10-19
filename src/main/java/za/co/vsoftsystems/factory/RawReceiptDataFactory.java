package za.co.vsoftsystems.factory;

import za.co.vsoftsystems.domain.RawReceiptData;

public class RawReceiptDataFactory {
    public static RawReceiptData createRawReceiptData(Long id, String fileName, String RawData) {
        return new RawReceiptData.Builder()
                .id(id)
                .fileName(fileName)
                .RawData(RawData)
                .build();
    }
    public static RawReceiptData createRawReceiptData(RawReceiptData rawReceiptData) {
        return new RawReceiptData.Builder()
                .id(rawReceiptData.getId())
                .fileName(rawReceiptData.getFileName())
                .RawData(rawReceiptData.getRawData())
                .build();
    }
    public static RawReceiptData createRawReceiptData(Long id, String fileName) {
        return new RawReceiptData.Builder()
                .id(id)
                .fileName(fileName)
                .build();
    }
    public static RawReceiptData createRawReceiptData(String fileName, String RawData) {
        return new RawReceiptData.Builder()
                .fileName(fileName)
                .RawData(RawData)
                .build();
    }
}

