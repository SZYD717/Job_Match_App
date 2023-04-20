package edu.comp7506.jobMatchApp.model;


import java.io.Serializable;
import java.util.Date;


public class WorkExperience implements Serializable {

    private String workExperienceId;

    private String resumeId;

    private Date workStartTime;

    private Date workEndTime;

    private String workCompanyName;

    private String workPosition;

    private String workDepartment;

    private String workCompanyScale;

    private String workCompanyProperty;

    private String workDesc;

    private String workType;

    private Integer status;

    public WorkExperience() {
    }

    public WorkExperience(String workExperienceId, String resumeId, Date workStartTime, Date workEndTime, String workCompanyName, String workPosition, String workDepartment, String workCompanyScale, String workCompanyProperty, String workDesc, String workType, Integer status) {
        this.workExperienceId = workExperienceId;
        this.resumeId = resumeId;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.workCompanyName = workCompanyName;
        this.workPosition = workPosition;
        this.workDepartment = workDepartment;
        this.workCompanyScale = workCompanyScale;
        this.workCompanyProperty = workCompanyProperty;
        this.workDesc = workDesc;
        this.workType = workType;
        this.status = status;
    }

    public String getWorkExperienceId() {
        return workExperienceId;
    }

    public void setWorkExperienceId(String workExperienceId) {
        this.workExperienceId = workExperienceId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public Date getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Date workStartTime) {
        this.workStartTime = workStartTime;
    }

    public Date getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Date workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getWorkCompanyName() {
        return workCompanyName;
    }

    public void setWorkCompanyName(String workCompanyName) {
        this.workCompanyName = workCompanyName;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getWorkDepartment() {
        return workDepartment;
    }

    public void setWorkDepartment(String workDepartment) {
        this.workDepartment = workDepartment;
    }

    public String getWorkCompanyScale() {
        return workCompanyScale;
    }

    public void setWorkCompanyScale(String workCompanyScale) {
        this.workCompanyScale = workCompanyScale;
    }

    public String getWorkCompanyProperty() {
        return workCompanyProperty;
    }

    public void setWorkCompanyProperty(String workCompanyProperty) {
        this.workCompanyProperty = workCompanyProperty;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}