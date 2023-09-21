package za.co.vsoftsystems.domain;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: ReceiptData.java
* Description: This is the ReceiptData domain class
*
* */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "receipt_data")
public class ReceiptData {
    @Id
    private int id;
    @Column(name = "center_name")
    private String centerName;
    @Column(name = "name")
    private String name;
    @Column(name = "vfs_reference")
    private String vfsReference;
    @Column(name = "visa_category")
    private String visaCategory;
    @Column(name = "subcategory")
    private String subcategory;
    @Column(name = "subtype")
    private String subtype;




    public ReceiptData() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Builder class
    public static class Builder {
        private String centerName;
        private String name;
        private String vfsReference;
        private String visaCategory;
        private String subcategory;
        private String subtype;

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
            receiptData.centerName = this.centerName;
            receiptData.name = this.name;
            receiptData.vfsReference = this.vfsReference;
            receiptData.visaCategory = this.visaCategory;
            receiptData.subcategory = this.subcategory;
            receiptData.subtype = this.subtype;
            return receiptData;
        }
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
