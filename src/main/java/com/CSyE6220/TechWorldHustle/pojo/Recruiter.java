/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.pojo;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author jyoti
 */
public class Recruiter extends User{
    @NotEmpty(message = "FirstName cannot be empty.")
    private String firstName;
    @NotEmpty(message = "LastName cannot be empty.")
    private String lastName;
    @NotEmpty(message = "Company is required.")
    private String company;
    @NotNull(message = "DOB is required")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dob;
    private String gender;
    @NotEmpty(message = "Contact is required.")
    private String contact;
    @NotEmpty(message = "Location cannot be empty.")
    private String current_location;
    
    public Recruiter() {}

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
    
 
    
}
