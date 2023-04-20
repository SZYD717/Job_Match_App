package edu.comp7506.jobMatchApp.model;

import java.io.Serializable;

public class Company implements Serializable {

    private String companyId;

    private String companyName;

    private String companyLogo;

    private String companyStage;

    private String companyEmpCount;

    private String companyIndustry;

    private String companyDesc;

    private String companyWebsite;

    private String companyAddressProvince;

    private String companyAddressCity;

    private String companyAddressDetail;

    private Integer status;

    public Company() {
    }

    public Company(String companyId, String companyName, String companyLogo, String companyStage, String companyEmpCount, String companyIndustry, String companyDesc, String companyWebsite, String companyAddressProvince, String companyAddressCity, String companyAddressDetail, Integer status) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.companyStage = companyStage;
        this.companyEmpCount = companyEmpCount;
        this.companyIndustry = companyIndustry;
        this.companyDesc = companyDesc;
        this.companyWebsite = companyWebsite;
        this.companyAddressProvince = companyAddressProvince;
        this.companyAddressCity = companyAddressCity;
        this.companyAddressDetail = companyAddressDetail;
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyStage() {
        return companyStage;
    }

    public void setCompanyStage(String companyStage) {
        this.companyStage = companyStage;
    }

    public String getCompanyEmpCount() {
        return companyEmpCount;
    }

    public void setCompanyEmpCount(String companyEmpCount) {
        this.companyEmpCount = companyEmpCount;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyAddressProvince() {
        return companyAddressProvince;
    }

    public void setCompanyAddressProvince(String companyAddressProvince) {
        this.companyAddressProvince = companyAddressProvince;
    }

    public String getCompanyAddressCity() {
        return companyAddressCity;
    }

    public void setCompanyAddressCity(String companyAddressCity) {
        this.companyAddressCity = companyAddressCity;
    }

    public String getCompanyAddressDetail() {
        return companyAddressDetail;
    }

    public void setCompanyAddressDetail(String companyAddressDetail) {
        this.companyAddressDetail = companyAddressDetail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}