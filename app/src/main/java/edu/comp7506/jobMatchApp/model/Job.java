package edu.comp7506.jobMatchApp.model;

import java.io.Serializable;


public class Job implements Serializable {

    private String jobId;

    private String companyId;

    private String jobName;

    private String jobCity;

    private String jobYear;

    private String jobDegree;

    private Integer jobNeedNumber;

    private String jobPublishTime;

    private String jobWelfare;

    private String jobDuty;

    private String jobDemand;

    private String jobAddressDetails;

    private int jobMinSalary;

    private int jobMaxSalary;

    private String jobSearchKeyword;

    private Integer status;

    public Job() {
    }

    public Job(String jobId, String companyId, String jobName, String jobCity, String jobYear, String jobDegree, Integer jobNeedNumber, String jobPublishTime, String jobWelfare, String jobDuty, String jobDemand, String jobAddressDetails, int jobMinSalary, int jobMaxSalary, String jobSearchKeyword, Integer status) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.jobName = jobName;
        this.jobCity = jobCity;
        this.jobYear = jobYear;
        this.jobDegree = jobDegree;
        this.jobNeedNumber = jobNeedNumber;
        this.jobPublishTime = jobPublishTime;
        this.jobWelfare = jobWelfare;
        this.jobDuty = jobDuty;
        this.jobDemand = jobDemand;
        this.jobAddressDetails = jobAddressDetails;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
        this.jobSearchKeyword = jobSearchKeyword;
        this.status = status;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public String getJobYear() {
        return jobYear;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
    }

    public String getJobDegree() {
        return jobDegree;
    }

    public void setJobDegree(String jobDegree) {
        this.jobDegree = jobDegree;
    }

    public Integer getJobNeedNumber() {
        return jobNeedNumber;
    }

    public void setJobNeedNumber(Integer jobNeedNumber) {
        this.jobNeedNumber = jobNeedNumber;
    }

    public String getJobPublishTime() {
        return jobPublishTime;
    }

    public void setJobPublishTime(String jobPublishTime) {
        this.jobPublishTime = jobPublishTime;
    }

    public String getJobWelfare() {
        return jobWelfare;
    }

    public void setJobWelfare(String jobWelfare) {
        this.jobWelfare = jobWelfare;
    }

    public String getJobDuty() {
        return jobDuty;
    }

    public void setJobDuty(String jobDuty) {
        this.jobDuty = jobDuty;
    }

    public String getJobDemand() {
        return jobDemand;
    }

    public void setJobDemand(String jobDemand) {
        this.jobDemand = jobDemand;
    }

    public String getJobAddressDetails() {
        return jobAddressDetails;
    }

    public void setJobAddressDetails(String jobAddressDetails) {
        this.jobAddressDetails = jobAddressDetails;
    }

    public int getJobMinSalary() {
        return jobMinSalary;
    }

    public void setJobMinSalary(int jobMinSalary) {
        this.jobMinSalary = jobMinSalary;
    }

    public int getJobMaxSalary() {
        return jobMaxSalary;
    }

    public void setJobMaxSalary(int jobMaxSalary) {
        this.jobMaxSalary = jobMaxSalary;
    }

    public String getJobSearchKeyword() {
        return jobSearchKeyword;
    }

    public void setJobSearchKeyword(String jobSearchKeyword) {
        this.jobSearchKeyword = jobSearchKeyword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}