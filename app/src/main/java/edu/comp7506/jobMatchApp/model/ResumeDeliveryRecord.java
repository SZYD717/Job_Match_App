package edu.comp7506.jobMatchApp.model;

import java.io.Serializable;
import java.util.Date;

public class ResumeDeliveryRecord implements Serializable {

    private String resumeDeliveryRecordId;

    private String customerId;

    private String companyName;

    private String resumeId;

    private String resumeName;

    private String jobId;

    private String jobName;

    private Date deliveryTime;

    private String resumeRealName;

    private int deliveryStatus; //0:waiting, -1:rejected, 1:accept

    public ResumeDeliveryRecord() {
    }

    public ResumeDeliveryRecord(String resumeDeliveryRecordId, String customerId, String companyName, String resumeId, String resumeName, String jobId, String jobName, Date deliveryTime, String resumeRealName, int deliveryStatus) {
        this.resumeDeliveryRecordId = resumeDeliveryRecordId;
        this.customerId = customerId;
        this.companyName = companyName;
        this.resumeId = resumeId;
        this.resumeName = resumeName;
        this.jobId = jobId;
        this.jobName = jobName;
        this.deliveryTime = deliveryTime;
        this.resumeRealName = resumeRealName;
        this.deliveryStatus = deliveryStatus;
    }

    public String getResumeDeliveryRecordId() {
        return resumeDeliveryRecordId;
    }

    public void setResumeDeliveryRecordId(String resumeDeliveryRecordId) {
        this.resumeDeliveryRecordId = resumeDeliveryRecordId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getResumeRealName() {
        return resumeRealName;
    }

    public void setResumeRealName(String resumeRealName) {
        this.resumeRealName = resumeRealName;
    }

    public int getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
