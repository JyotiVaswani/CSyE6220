/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;

import com.CSyE6220.TechWorldHustle.DAO.RecruiterDAO;
import com.CSyE6220.TechWorldHustle.pojo.Recruiter;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jyoti
 */
@Controller
public class RegisterRecruiterController {
    
          
    @RequestMapping(value= "/RegisterRecruiter.htm", method=RequestMethod.GET)  
    public String showForm(ModelMap model, Recruiter recruiter){   
        return "RegisterRecruiter";  
    } 
    
 
    
    @RequestMapping(value="/RegisterRecruiter.htm",method = RequestMethod.POST)   
    public ModelAndView save(@Valid @ModelAttribute("recruiter") Recruiter recruiter, BindingResult result, SessionStatus status, RecruiterDAO RDao){  
        if(result.hasErrors())
        { return new ModelAndView ("RegisterRecruiter"); }
        else {
        RDao.addRecruiter(recruiter); 
        return new ModelAndView("RegistrationSuccess", "successMessage", "You have been successfully Registered!");
             }  
    }  
    
    
}
