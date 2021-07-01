/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;

import com.CSyE6220.TechWorldHustle.DAO.RecruiterDAO;
import com.CSyE6220.TechWorldHustle.DAO.SkillDAO;
import com.CSyE6220.TechWorldHustle.DAO.WalkInDriveDAO;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import com.CSyE6220.TechWorldHustle.pojo.WalkInDrive;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jyoti
 */
@Controller
public class WalkInDriveController {
    
    @Autowired
    WalkInDriveDAO WDDao;
    @Autowired
    RecruiterDAO RDao;
    
    @RequestMapping(value= "/recruiter/AddWalkInDrive.htm", method=RequestMethod.GET)  
    public String showForm(ModelMap model, WalkInDrive walkInDrive , HttpServletRequest request){ 
        return "recruiter/AddWalkInDrive";  
    }
  
    @RequestMapping(value="/recruiter/AddWalkInDrive.htm", method = RequestMethod.POST)  
    public ModelAndView save(@Valid @ModelAttribute("walkInDrive") WalkInDrive walkInDrive, BindingResult result,HttpServletRequest request){  
         HttpSession session = request.getSession();
            walkInDrive.setRecruiterId(RDao.getRecruiter((int)session.getAttribute("login_user"))); 
            WDDao.addWalkInDrive(walkInDrive);
            return new ModelAndView("recruiter/JobActivitySuccess", "successMessage", "WalkIn-Drive been posted successfully!");
        } 
    
    
    @RequestMapping(value="/candidate/ViewWalkInDrive.htm", method = RequestMethod.GET)  
    public ModelAndView fetchWalkInDrive(HttpServletRequest request){  
        HttpSession session = request.getSession();
        List <WalkInDrive> walkInDrive_list = WDDao.getWalkInDriveList();
        return new ModelAndView("candidate/displayWalkInDrive", "WalkInDrivePosted", walkInDrive_list);
    }
}
