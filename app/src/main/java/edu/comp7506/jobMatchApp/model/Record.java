package edu.comp7506.jobMatchApp.model;

import java.io.Serializable;

public class Record implements Serializable {
    public Record() {}

    public Record(String companyName,String customerId,int deliveryStatus,String deliveryTime,String jobId,String jobName,String resumeDeliveryRecordId,String resumeId,String resumeName,String resumeRealName){
        this.companyName = companyName;
        this.customerId = customerId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryTime = deliveryTime;
        this.jobId = jobId;
        this.jobName = jobName;
        this.resumeDeliveryRecordId = resumeDeliveryRecordId;
        this.resumeId = resumeId;
        this.resumeName = resumeName;
        this.resumeRealName = resumeRealName;

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getResumeDeliveryRecordId() {
        return resumeDeliveryRecordId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public String getResumeRealName() {
        return resumeRealName;
    }

    private String companyName;
    private String customerId;
    private int deliveryStatus;
    private String deliveryTime;
    private String jobId;
    private String jobName;
    private String resumeDeliveryRecordId;
    private String resumeId;
    private String resumeName;
    private String resumeRealName;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setResumeDeliveryRecordId(String resumeDeliveryRecordId) {
        this.resumeDeliveryRecordId = resumeDeliveryRecordId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public void setResumeRealName(String resumeRealName) {
        this.resumeRealName = resumeRealName;
    }
}
