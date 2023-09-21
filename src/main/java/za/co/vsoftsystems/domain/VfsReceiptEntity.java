package za.co.vsoftsystems.domain;
/*
* Author: Peter Buckingham (220165289)
* Date: 20 Sep 2023
* File: VfsReceiptEntity.java
* Description: This is the VfsReceiptEntity domain class
*
* */
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "api_vfsreceipt")
public class VfsReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VFSReceiptID")
    private Long vfsReceiptID;

    @Column(name = "Agency")
    private String agency;

    @Column(name = "HA_Ref_No")
    private String haRefNo;

    @Column(name = "CMSClientNo")
    private Integer cmsClientNo;

    @Column(name = "PPNo")
    private String ppNo;

    @Column(name = "VfsOffice")
    private String vfsOffice;

    @Column(name = "DocType")
    private String docType;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "VisaType")
    private String visaType;

    @Column(name = "SubVisaCategory")
    private String subVisaCategory;

    @Column(name = "SubVisaTypeCat")
    private String subVisaTypeCat;

    @Column(name = "Email")
    private String email;

    @Column(name = "TelCell")
    private String telCell;

    @Column(name = "Folder")
    private String folder;

    @Column(name = "Filename")
    private String filename;

    @Column(name = "ProcessedOCR")
    private String processedOCR;

    @Column(name = "Sync2CMS")
    private String sync2CMS;

    @Column(name = "CreDate")
    private Date creDate;

    @Column(name = "CreTime")
    private Time creTime;

    @Column(name = "CreUser")
    private String creUser;

    @Column(name = "CreReport")
    private String creReport;

    @Column(name = "ModDate")
    private Date modDate;

    @Column(name = "ModTime")
    private Time modTime;

    @Column(name = "ModUser")
    private String modUser;

    @Column(name = "ModProg")
    private String modProg;

    @Column(name = "ModFlag")
    private String modFlag;

    @Column(name = "SyncDtTm")
    private Date syncDtTm;

    @Column(name = "DelDate")
    private Date delDate;

    @Column(name = "DelTime")
    private Time delTime;

    @Column(name = "DelUser")
    private String delUser;

    @Column(name = "DelReason")
    private String delReason;

    @Column(name = "RecStatus")
    private String recStatus;

    @Column(name = "Send2CMS")
    private String send2CMS;

    // Add getters and setters for all fields

    public Long getVfsReceiptID() {
        return vfsReceiptID;
    }

    public void setVfsReceiptID(Long vfsReceiptID) {
        this.vfsReceiptID = vfsReceiptID;
    }

    // Add getters and setters for other fields

    // Override toString() if needed
}
