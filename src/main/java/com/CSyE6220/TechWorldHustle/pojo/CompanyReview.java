/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.pojo;

import java.util.Date;

/**
 *
 * @author jyoti
 */
public class CompanyReview {
    
    private int reviewId;
    private String jobTitle;
    private String company;
    private String employmentStatus;
    private int lastYearOfEmployment;
    private String employmentType;
    private String pros;
    private String cons;
    private String adviceToManagement;
    private String additionalComments;
    private Date reviewDate;
    private IndividualRating rating;  // IndividualRating provided by reviewer

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public int getLastYearOfEmployment() {
        return lastYearOfEmployment;
    }

    public void setLastYearOfEmployment(int lastYearOfEmployment) {
        this.lastYearOfEmployment = lastYearOfEmployment;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getAdviceToManagement() {
        return adviceToManagement;
    }

    public void setAdviceToManagement(String adviceToManagement) {
        this.adviceToManagement = adviceToManagement;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public IndividualRating getRating() {
        return rating;
    }

    public void setRating(IndividualRating rating) {
        this.rating = rating;
    }





   
    
}
