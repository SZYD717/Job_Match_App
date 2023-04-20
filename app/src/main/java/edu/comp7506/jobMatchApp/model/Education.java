package edu.comp7506.jobMatchApp.model;


import java.io.Serializable;
import java.util.Date;

public class Education implements Serializable {

    private String educationId;

    private String resumeId;

    private Date educationStartTime;

    private Date educationEndTime;

    private String schoolName;

    private Integer degree;

    private Integer status;

    public Education() {
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public Date getEducationStartTime() {
        return educationStartTime;
    }

    public void setEducationStartTime(Date educationStartTime) {
        this.educationStartTime = educationStartTime;
    }

    public Date getEducationEndTime() {
        return educationEndTime;
    }

    public void setEducationEndTime(Date educationEndTime) {
        this.educationEndTime = educationEndTime;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}