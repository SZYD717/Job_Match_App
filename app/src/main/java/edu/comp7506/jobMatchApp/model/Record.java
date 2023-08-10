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
}
