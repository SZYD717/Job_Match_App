package edu.comp7506.jobMatchApp.model;


import java.io.Serializable;
import java.util.Date;

public class ProjectExperience implements Serializable {

    private String projectExperienceId;

    private String resumeId;

    private Date projectStartTime;

    private Date projectEndTime;

    private String projectCompanyName;

    private String projectName;

    private String projectContentDesc;

    private String projectDutyDesc;

    private Integer status;

    public ProjectExperience() {
    }

    public ProjectExperience(String projectExperienceId, String resumeId, Date projectStartTime, Date projectEndTime, String projectCompanyName, String projectName, String projectContentDesc, String projectDutyDesc, Integer status) {
        this.projectExperienceId = projectExperienceId;
        this.resumeId = resumeId;
        this.projectStartTime = projectStartTime;
        this.projectEndTime = projectEndTime;
        this.projectCompanyName = projectCompanyName;
        this.projectName = projectName;
        this.projectContentDesc = projectContentDesc;
        this.projectDutyDesc = projectDutyDesc;
        this.status = status;
    }

    public String getProjectExperienceId() {
        return projectExperienceId;
    }

    public void setProjectExperienceId(String projectExperienceId) {
        this.projectExperienceId = projectExperienceId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public String getProjectCompanyName() {
        return projectCompanyName;
    }

    public void setProjectCompanyName(String projectCompanyName) {
        this.projectCompanyName = projectCompanyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectContentDesc() {
        return projectContentDesc;
    }

    public void setProjectContentDesc(String projectContentDesc) {
        this.projectContentDesc = projectContentDesc;
    }

    public String getProjectDutyDesc() {
        return projectDutyDesc;
    }

    public void setProjectDutyDesc(String projectDutyDesc) {
        this.projectDutyDesc = projectDutyDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
