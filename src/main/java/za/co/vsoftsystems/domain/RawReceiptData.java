package za.co.vsoftsystems.domain;
/**
* Author: Peter Buckingham
* File: RawReceiptData.java
* Description: This is the RawReceiptData domain class
* This class defines the RawReceiptData object
* */

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "raw_receipt_data")
public class RawReceiptData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-incrementing primary key
        private Long id;

        @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
        private String fileName;
        @Column(columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
        private String RawData;

        @Column(name = "timestamp")
        private Date timestamp;

        public RawReceiptData(Builder builder) {

        }

        public RawReceiptData(String fileName, String RawData) {
                this.fileName = fileName;
                this.RawData = RawData;
        }

        public RawReceiptData() {

        }

        @PrePersist
        protected void onCreate() {
                timestamp = new Date(System.currentTimeMillis());
        }

        //getters and setters
        public void setId(Long id) {
                this.id = id;
        }

        public Long getId() {
                return id;
        }

        public void setRawData(String RawData) {
                this.RawData = RawData;
        }

        public String getRawData() {
                return RawData;
        }
        public void setFileName(String fileName) {
                this.fileName = fileName;
        }
        public void setTimestamp(Date timestamp) {
                this.timestamp = timestamp;
        }

        public Date getTimestamp() {
                return timestamp;
        }

        public String getFileName() {
                return fileName;
        }

        // Builder class
        public static class Builder {
                private Long id;
                private String fileName;
                private String RawData;

                public Builder id(Long id) {
                        this.id = id;
                        return this;
                }
                public Builder fileName(String fileName) {
                        this.fileName = fileName;
                        return this;
                }

                public Builder RawData(String RawData) {
                        this.RawData = RawData;
                        return this;
                }

                public Builder copy(RawReceiptData rawReceiptData) {
                        this.id = rawReceiptData.id;
                        this.fileName = rawReceiptData.fileName;
                        this.RawData = rawReceiptData.RawData;
                        return this;
                }

                public RawReceiptData build() {
                        return new RawReceiptData(this);
                }
        }

}
