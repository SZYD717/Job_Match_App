package edu.comp7506.jobMatchApp.VO;

import java.io.Serializable;
import java.util.Date;

public class JobVO implements Serializable {

    private String jobId;
    private String companyId;
    private String companyName;
    private String companyEmpCount;
    private String companyIndustry;
    private String companyLogo;
    private String jobName;
    private String jobCity;
    private String jobYear;
    private String jobDegree;
    private int jobNeedNumber;
    private String jobPublishTime;
    private String jobWelfare;
    private String jobDuty;
    private String jobDemand;
    private String jobAddress;
    private int jobMinSalary;
    private int jobMaxSalary;
    private String jobSearchKeyword;
    private String jobReferralEmail;
    private String jobReferralPosition;
    private String status;

    public JobVO() {
    }

    public JobVO(String jobId, String companyId, String companyName, String companyEmpCount, String companyIndustry, String companyLogo, String jobName, String jobCity, String jobYear, String jobDegree, int jobNeedNumber, String jobPublishTime, String jobWelfare, String jobDuty, String jobDemand, String jobAddress, int jobMinSalary, int jobMaxSalary, String jobSearchKeyword, String jobReferralEmail, String jobReferralPosition, String status) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmpCount = companyEmpCount;
        this.companyIndustry = companyIndustry;
        this.companyLogo = companyLogo;
        this.jobName = jobName;
        this.jobCity = jobCity;
        this.jobYear = jobYear;
        this.jobDegree = jobDegree;
        this.jobNeedNumber = jobNeedNumber;
        this.jobPublishTime = jobPublishTime;
        this.jobWelfare = jobWelfare;
        this.jobDuty = jobDuty;
        this.jobDemand = jobDemand;
        this.jobAddress = jobAddress;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
        this.jobSearchKeyword = jobSearchKeyword;
        this.jobReferralEmail = jobReferralEmail;
        this.jobReferralPosition = jobReferralPosition;
        this.status = status;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getJobId() {
        return jobId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyEmpCount(String companyEmpCount) {
        this.companyEmpCount = companyEmpCount;
    }
    public String getCompanyEmpCount() {
        return companyEmpCount;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }
    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }
    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getJobName() {
        return jobName;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }
    public String getJobCity() {
        return jobCity;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
    }
    public String getJobYear() {
        return jobYear;
    }

    public void setJobDegree(String jobDegree) {
        this.jobDegree = jobDegree;
    }
    public String getJobDegree() {
        return jobDegree;
    }

    public void setJobNeedNumber(int jobNeedNumber) {
        this.jobNeedNumber = jobNeedNumber;
    }
    public int getJobNeedNumber() {
        return jobNeedNumber;
    }

    public void setJobPublishTime(String jobPublishTime) {
        this.jobPublishTime = jobPublishTime;
    }
    public String getJobPublishTime() {
        return jobPublishTime;
    }

    public void setJobWelfare(String jobWelfare) {
        this.jobWelfare = jobWelfare;
    }
    public String getJobWelfare() {
        return jobWelfare;
    }

    public void setJobDuty(String jobDuty) {
        this.jobDuty = jobDuty;
    }
    public String getJobDuty() {
        return jobDuty;
    }

    public void setJobDemand(String jobDemand) {
        this.jobDemand = jobDemand;
    }
    public String getJobDemand() {
        return jobDemand;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }
    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobMinSalary(int jobMinSalary) {
        this.jobMinSalary = jobMinSalary;
    }
    public int getJobMinSalary() {
        return jobMinSalary;
    }

    public void setJobMaxSalary(int jobMaxSalary) {
        this.jobMaxSalary = jobMaxSalary;
    }
    public int getJobMaxSalary() {
        return jobMaxSalary;
    }

    public void setJobSearchKeyword(String jobSearchKeyword) {
        this.jobSearchKeyword = jobSearchKeyword;
    }
    public String getJobSearchKeyword() {
        return jobSearchKeyword;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public String getJobReferralEmail() {
        return jobReferralEmail;
    }

    public void setJobReferralEmail(String jobReferralEmail) {
        this.jobReferralEmail = jobReferralEmail;
    }

    public String getJobReferralPosition() {
        return jobReferralPosition;
    }

    public void setJobReferralPosition(String jobReferralPosition) {
        this.jobReferralPosition = jobReferralPosition;
    }
}