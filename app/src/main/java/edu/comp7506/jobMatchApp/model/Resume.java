package edu.comp7506.jobMatchApp.model;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable {

    private String resumeId;
    private String customerId;
    private String resumeName;
    private String resumeRealName;
    private String resumeCreateTime;
    private String resumeUpdateTime;
    private String resumeProfile;
    private String resumeBirth;
    private Long resumeTele;
    private String resumeEmail;
    private String resumeGender;
    private String resumeLeavingWorking;
    private String resumeLiveCity;
    private String resumeIdCard;
    private Integer resumeIncome;
    private String resumeWorkType; //0:part time,1:full time
    private Integer status;
    public Resume() {
    }

    public Resume(String resumeId, String customerId, String resumeName, String resumeRealName, String resumeCreateTime, String resumeUpdateTime, String resumeProfile, String resumeBirth, Long resumeTele, String resumeEmail, String resumeGender, String resumeLeavingWorking, String resumeLiveCity, String resumeIdCard, Integer resumeIncome, String resumeWorkType, Integer status) {
        this.resumeId = resumeId;
        this.customerId = customerId;
        this.resumeName = resumeName;
        this.resumeRealName = resumeRealName;
        this.resumeCreateTime = resumeCreateTime;
        this.resumeUpdateTime = resumeUpdateTime;
        this.resumeProfile = resumeProfile;
        this.resumeBirth = resumeBirth;
        this.resumeTele = resumeTele;
        this.resumeEmail = resumeEmail;
        this.resumeGender = resumeGender;
        this.resumeLeavingWorking = resumeLeavingWorking;
        this.resumeLiveCity = resumeLiveCity;
        this.resumeIdCard = resumeIdCard;
        this.resumeIncome = resumeIncome;
        this.resumeWorkType = resumeWorkType;
        this.status = status;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getResumeRealName() {
        return resumeRealName;
    }

    public void setResumeRealName(String resumeRealName) {
        this.resumeRealName = resumeRealName;
    }

    public String getResumeCreateTime() {
        return resumeCreateTime;
    }

    public void setResumeCreateTime(String resumeCreateTime) {
        this.resumeCreateTime = resumeCreateTime;
    }

    public String getResumeUpdateTime() {
        return resumeUpdateTime;
    }

    public void setResumeUpdateTime(String resumeUpdateTime) {
        this.resumeUpdateTime = resumeUpdateTime;
    }

    public String getResumeProfile() {
        return resumeProfile;
    }

    public void setResumeProfile(String resumeProfile) {
        this.resumeProfile = resumeProfile;
    }

    public String getResumeBirth() {
        return resumeBirth;
    }

    public void setResumeBirth(String resumeBirth) {
        this.resumeBirth = resumeBirth;
    }

    public Long getResumeTele() {
        return resumeTele;
    }

    public void setResumeTele(Long resumeTele) {
        this.resumeTele = resumeTele;
    }

    public String getResumeEmail() {
        return resumeEmail;
    }

    public void setResumeEmail(String resumeEmail) {
        this.resumeEmail = resumeEmail;
    }

    public String getResumeGender() {
        return resumeGender;
    }

    public void setResumeGender(String resumeGender) {
        this.resumeGender = resumeGender;
    }

    public String getResumeLeavingWorking() {
        return resumeLeavingWorking;
    }

    public void setResumeLeavingWorking(String resumeLeavingWorking) {
        this.resumeLeavingWorking = resumeLeavingWorking;
    }

    public String getResumeLiveCity() {
        return resumeLiveCity;
    }

    public void setResumeLiveCity(String resumeLiveCity) {
        this.resumeLiveCity = resumeLiveCity;
    }

    public String getResumeIdCard() {
        return resumeIdCard;
    }

    public void setResumeIdCard(String resumeIdCard) {
        this.resumeIdCard = resumeIdCard;
    }

    public Integer getResumeIncome() {
        return resumeIncome;
    }

    public void setResumeIncome(Integer resumeIncome) {
        this.resumeIncome = resumeIncome;
    }

    public String getResumeWorkType() {
        return resumeWorkType;
    }

    public void setResumeWorkType(String resumeWorkType) {
        this.resumeWorkType = resumeWorkType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
