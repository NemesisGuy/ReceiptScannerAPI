package za.co.vsoftsystems.domain;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: ReceiptData.java
* Description: This is the ReceiptData domain class
* This class defines the ReceiptData object
*
* */
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "extracted_receipt_data")
public class ReceiptData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-incrementing primary key
    private int id;
    @Column(name = "file_name", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci" )
    private String fileName;
    @Column(name = "center_name", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci" )
    private String centerName;
    @Column(name = "name",columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String name;
    @Column(name = "vfs_reference",columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String vfsReference;
    @Column(name = "visa_category",columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String visaCategory;
    @Column(name = "subcategory",columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String subcategory;
    @Column(name = "subtype",columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String subtype;
    @Column(name = "timestamp",columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private Date timestamp;



    public ReceiptData() {

    }
    @PrePersist
    protected void onCreate() {
        timestamp = new Date(System.currentTimeMillis());
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFileName(String name) {
        this.fileName = name;
    }
    public void getFileName(String fileName) {
        this.fileName = fileName;
    }

    // Builder class
    public static class Builder {
        private int id;
        private String fileName;
        private String centerName;
        private String name;
        private String vfsReference;
        private String visaCategory;
        private String subcategory;
        private String subtype;

        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        public Builder centerName(String centerName) {
            this.centerName = centerName;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder vfsReference(String vfsReference) {
            this.vfsReference = vfsReference;
            return this;
        }

        public Builder visaCategory(String visaCategory) {
            this.visaCategory = visaCategory;
            return this;
        }

        public Builder subcategory(String subcategory) {
            this.subcategory = subcategory;
            return this;
        }

        public Builder subtype(String subtype) {
            this.subtype = subtype;
            return this;
        }

        public ReceiptData build() {

            ReceiptData receiptData = new ReceiptData();

            receiptData.id = this.id;
            receiptData.fileName = this.fileName;
            receiptData.centerName = this.centerName;
            receiptData.name = this.name;
            receiptData.vfsReference = this.vfsReference;
            receiptData.visaCategory = this.visaCategory;
            receiptData.subcategory = this.subcategory;
            receiptData.subtype = this.subtype;
            return receiptData;
        }
    }
/*    public int getId() {
        return id;
    }*/

    public String getFileName() {
        return fileName;
    }
    public String getCenterName() {
        return centerName;
    }

    public String getName() {
        return name;
    }

    public String getVfsReference() {
        return vfsReference;
    }

    public String getVisaCategory() {
        return visaCategory;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getSubtype() {
        return subtype;
    }


}
