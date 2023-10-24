package za.co.vsoftsystems.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "api_vfsreceipt")
public class VFSReceiptData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VFSReceiptID")
    private int vfsReceiptID;

    @Column(name = "Agency")
    private String agency;

    @Column(name = "HA_Ref_No")
    private String haRefNo;

    @Column(name = "CMSClientNo")
    private int cmsClientNo;

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
    @Column(name = "visa_type", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
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
    private String creTime;

    @Column(name = "CreUser")
    private String creUser;

    @Column(name = "CreReport")
    private String creReport;

    @Column(name = "ModDate")
    private Date modDate;

    @Column(name = "ModTime")
    private String modTime;

    @Column(name = "ModUser")
    private String modUser;

    @Column(name = "ModProg")
    private String modProg;

    @Column(name = "ModFlag")
    private String modFlag;

    @Column(name = "SyncDtTm")
    private String syncDtTm;

    @Column(name = "DelDate")
    private Date delDate;

    @Column(name = "DelTime")
    private String delTime;

    @Column(name = "DelUser")
    private String delUser;

    @Column(name = "DelReason")
    private String delReason;

    @Column(name = "RecStatus")
    private String recStatus;

    @Column(name = "Send2CMS")
    private String send2CMS;

    public VFSReceiptData() {
    }

    public int getVfsReceiptID() {
        return vfsReceiptID;
    }

    public void setVfsReceiptID(int vfsReceiptID) {
        this.vfsReceiptID = vfsReceiptID;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getHaRefNo() {
        return haRefNo;
    }

    public void setHaRefNo(String haRefNo) {
        this.haRefNo = haRefNo;
    }

    public int getCmsClientNo() {
        return cmsClientNo;
    }

    public void setCmsClientNo(int cmsClientNo) {
        this.cmsClientNo = cmsClientNo;
    }

    public String getPpNo() {
        return ppNo;
    }

    public void setPpNo(String ppNo) {
        this.ppNo = ppNo;
    }

    public String getVfsOffice() {
        return vfsOffice;
    }

    public void setVfsOffice(String vfsOffice) {
        this.vfsOffice = vfsOffice;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getSubVisaCategory() {
        return subVisaCategory;
    }

    public void setSubVisaCategory(String subVisaCategory) {
        this.subVisaCategory = subVisaCategory;
    }

    public String getSubVisaTypeCat() {
        return subVisaTypeCat;
    }

    public void setSubVisaTypeCat(String subVisaTypeCat) {
        this.subVisaTypeCat = subVisaTypeCat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelCell() {
        return telCell;
    }

    public void setTelCell(String telCell) {
        this.telCell = telCell;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getProcessedOCR() {
        return processedOCR;
    }

    public void setProcessedOCR(String processedOCR) {
        this.processedOCR = processedOCR;
    }

    public String getSync2CMS() {
        return sync2CMS;
    }

    public void setSync2CMS(String sync2CMS) {
        this.sync2CMS = sync2CMS;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public String getCreReport() {
        return creReport;
    }

    public void setCreReport(String creReport) {
        this.creReport = creReport;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime;
    }

    public String getModUser() {
        return modUser;
    }

    public void setModUser(String modUser) {
        this.modUser = modUser;
    }

    public String getModProg() {
        return modProg;
    }

    public void setModProg(String modProg) {
        this.modProg = modProg;
    }

    public String getModFlag() {
        return modFlag;
    }

    public void setModFlag(String modFlag) {
        this.modFlag = modFlag;
    }

    public String getSyncDtTm() {
        return syncDtTm;
    }

    public void setSyncDtTm(String syncDtTm) {
        this.syncDtTm = syncDtTm;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getDelUser() {
        return delUser;
    }

    public void setDelUser(String delUser) {
        this.delUser = delUser;
    }

    public String getDelReason() {
        return delReason;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

    public String getSend2CMS() {
        return send2CMS;
    }

    public void setSend2CMS(String send2CMS) {
        this.send2CMS = send2CMS;
    }
    // Getters and setters for all fields

    // ...
}
