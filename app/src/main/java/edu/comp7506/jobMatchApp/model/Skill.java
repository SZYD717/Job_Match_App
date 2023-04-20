package edu.comp7506.jobMatchApp.model;

import java.io.Serializable;

public class Skill implements Serializable {

    private String skillId;

    private String resumeId;

    private String skillName;

    private String skillDesc;

    private int status;

    public Skill() {
    }

    public Skill(String skillId, String resumeId, String skillName, String skillDesc, int status) {
        this.skillId = skillId;
        this.resumeId = resumeId;
        this.skillName = skillName;
        this.skillDesc = skillDesc;
        this.status = status;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
