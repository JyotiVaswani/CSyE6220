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
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author jyoti
 */
public class Candidate extends User {
    @NotEmpty(message = "FirstName cannot be empty.")
    private String firstName;
    @NotEmpty(message = "LastName cannot be empty.")
    private String lastName;
    @NotEmpty(message = "Company is required.")
    private String current_Company;
    @NotNull(message = "DOB is required")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dob;
    private String gender;
    @NotEmpty(message = "Contact is required.")
    private String contact;
    @NotEmpty(message = "Location cannot be empty.")
    private String current_location;
    private String current_JobTitle;
    private MultipartFile cv_file;      //upload resume/CV
    private String cv;
    @NotNull(message = "Primary skills are required.")
    private String primary_skills;
    @NotEmpty(message = "Employment Type Preference is required.")
    private String employmentTypePreference;
    
    public Candidate() {}
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurrent_Company() {
        return current_Company;
    }

    public void setCurrent_Company(String current_Company) {
        this.current_Company = current_Company;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public String getCurrent_JobTitle() {
        return current_JobTitle;
    }

    public void setCurrent_JobTitle(String current_JobTitle) {
        this.current_JobTitle = current_JobTitle;
    }

    public MultipartFile getCv_file() {
        return cv_file;
    }

    public void setCv_file(MultipartFile cv_file) {
        this.cv_file = cv_file;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getPrimary_skills() {
        return primary_skills;
    }

    public void setPrimary_skills(String primary_skills) {
        this.primary_skills = primary_skills;
    }

    public String getEmploymentTypePreference() {
        return employmentTypePreference;
    }

    public void setEmploymentTypePreference(String employmentTypePreference) {
        this.employmentTypePreference = employmentTypePreference;
    }

    
}
