package za.co.vsoftsystems.service;
/**
 * Author: Peter Buckingham (220165289)
 * Date: 20 Sep 2023
 * File: ReceiptDataService.java
 * Description: This is the ReceiptDataService class
 * This class is used to store the extracted data from the files
 *
* */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.vsoftsystems.domain.ReceiptData;
import za.co.vsoftsystems.domain.VFSReceiptData;
import za.co.vsoftsystems.repository.ReceiptDataRepository;
import za.co.vsoftsystems.repository.VFSReceiptDataRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReceiptDataService {

    @Autowired
    private ReceiptDataRepository receiptDataRepository;
    @Autowired
    private VFSReceiptDataRepository vfsReceiptDataRepository;

    public void saveReceiptData(ReceiptData receiptData) {
        // Save data to the receipt_data table
        receiptDataRepository.save(receiptData);

        // Map fields from ReceiptData to VFSReceiptData
        VFSReceiptData vfsReceiptData = new VFSReceiptData();
        vfsReceiptData.setFirstName(receiptData.getName());
        vfsReceiptData.setVfsOffice(receiptData.getCenterName());
        vfsReceiptData.setHaRefNo(receiptData.getVfsReference());
        vfsReceiptData.setProcessedOCR("Y");
        vfsReceiptData.setFilename(receiptData.getFileName());
        vfsReceiptData.setVisaType(receiptData.getVisaCategory());
        vfsReceiptData.setSubVisaTypeCat(receiptData.getSubcategory());

        // Save data to the api_vfsreceipt table
        vfsReceiptDataRepository.save(vfsReceiptData);
    }

    public List<ReceiptData> getAllReceiptData() {
        return receiptDataRepository.findAll();
    }

    /*public void saveAllReceiptData(List<ReceiptData> receiptDataList) {
        receiptDataRepository.saveAll(receiptDataList);//save all data to database - this saves to the receipt_data table
    }*/
    public void saveAllReceiptData(List<ReceiptData> receiptDataList) {
        List<VFSReceiptData> vfsReceiptDataList = new ArrayList<>();

        for (ReceiptData receiptData : receiptDataList) {
            // Save data to the receipt_data table
            receiptDataRepository.save(receiptData);

            // Map fields from ReceiptData to VFSReceiptData
            VFSReceiptData vfsReceiptData = new VFSReceiptData();
            // Trim firstName if it exceeds the allowed length
            int maxFirstNameLength = 200; // Adjust as needed
            String firstName = receiptData.getName();
            vfsReceiptData.setFirstName(firstName.length() > maxFirstNameLength ? firstName.substring(0, maxFirstNameLength) : firstName);


            // Trim vfsOffice if it exceeds the allowed length
            int maxVfsOfficeLength = 30; // Adjust as needed
            String vfsOffice = receiptData.getCenterName();
            vfsReceiptData.setVfsOffice(vfsOffice.length() > maxVfsOfficeLength ? vfsOffice.substring(0, maxVfsOfficeLength) : vfsOffice);


            int maxHaRefNoLength = 200; // Adjust as needed
            String haRefNo = receiptData.getVfsReference();
            vfsReceiptData.setHaRefNo(haRefNo.length() > maxHaRefNoLength ? haRefNo.substring(0, maxHaRefNoLength) : haRefNo);

           // vfsReceiptData.setVisaType(receiptData.getVisaCategory());

            // Trim visaType if it exceeds the allowed length
            int maxVisaTypeLength = 200; // Adjust as needed
            String visaType = receiptData.getVisaCategory();
            vfsReceiptData.setVisaType(visaType.length() > maxVisaTypeLength ? visaType.substring(0, maxVisaTypeLength) : visaType);

            int maxSubVisaTypeCatLength = 200; // Adjust as needed
            String subVisaTypeCat = receiptData.getSubtype();
            vfsReceiptData.setSubVisaTypeCat(subVisaTypeCat.length() > maxSubVisaTypeCatLength ? subVisaTypeCat.substring(0, maxSubVisaTypeCatLength) : subVisaTypeCat);

            int maxSubVisaCategoryLength = 200; // Adjust as needed
            String subVisaCategory = receiptData.getSubcategory();
            vfsReceiptData.setSubVisaCategory(subVisaCategory.length() > maxSubVisaCategoryLength ? subVisaCategory.substring(0, maxSubVisaCategoryLength) : subVisaCategory);


            int maxFileNameLength = 200; // Adjust as needed
            String fileName = receiptData.getFileName();
            vfsReceiptData.setFilename(fileName.length() > maxFileNameLength ? fileName.substring(0, maxFileNameLength) : fileName);
          //  vfsReceiptData.setFilename(receiptData.getFileName());

            vfsReceiptData.setDocType("Receipt");
            vfsReceiptData.setProcessedOCR("Y");
            vfsReceiptData.setAgency("SAMI-HO");
            vfsReceiptData.setPpNo("");
            vfsReceiptData.setEmail("");
            vfsReceiptData.setFolder("");
            vfsReceiptData.setTelCell("");
            vfsReceiptData.setSync2CMS("");
            vfsReceiptData.setSend2CMS("");
            vfsReceiptData.setSyncDtTm("");
            vfsReceiptData.setRecStatus("");
            vfsReceiptData.setCmsClientNo(0);

            vfsReceiptDataList.add(vfsReceiptData);
        }

        // Save all VFSReceiptData to the api_vfsreceipt table
        vfsReceiptDataRepository.saveAll(vfsReceiptDataList);
    }

}
