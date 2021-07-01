/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author jyoti
 */
public class Job {
    
    private int jobId;
    @NotEmpty(message = "Job Title is required.")
    private String jobTitle;
    @NotEmpty(message = "Company is required.")
    private String company;
    @NotNull(message = "Start date is required")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date startDate;
    private String status;
    @NotNull(message = "Salary is required.")
    private double salaryOffered;
    @NotEmpty(message = "Location cannot be empty.")
    private String location;
    private String jobDescription;
    private Recruiter recId; // Reference id of Recruiter of this Job
  //  @NotNull(message = "Primary skills are required.")
    private String primary_skills;

    
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalaryOffered() {
        return salaryOffered;
    }

    public void setSalaryOffered(double salaryOffered) {
        this.salaryOffered = salaryOffered;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Recruiter getRecId() {
        return recId;
    }

    public void setRecId(Recruiter recId) {
        this.recId = recId;
    }

    public String getPrimary_skills() {
        return primary_skills;
    }

    public void setPrimary_skills(String primary_skills) {
        this.primary_skills = primary_skills;
    }


  
}
