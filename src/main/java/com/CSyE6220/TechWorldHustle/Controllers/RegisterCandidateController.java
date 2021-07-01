/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;

import com.CSyE6220.TechWorldHustle.DAO.CandidateDAO;
import com.CSyE6220.TechWorldHustle.DAO.SkillDAO;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jyoti
 */

@Controller
public class RegisterCandidateController {
   
    @Autowired
    SkillDAO SDao;
    @Autowired
    CandidateDAO CDao;
    
    @RequestMapping(value= "/RegisterCandidate.htm", method=RequestMethod.GET)  
    public ModelAndView showForm(ModelMap model, Candidate candidate){    
        List<Skill> skillset = SDao.getSkillList();
        List<String> universal_skillset = new ArrayList<String>();
        for (Skill s : skillset){universal_skillset.add(s.getSkillName());}
        return new ModelAndView("RegisterCandidate", "UniversalSkillSet", universal_skillset);
    } 

    
    @RequestMapping(value="/RegisterCandidate.htm",method = RequestMethod.POST)  
    public ModelAndView save(@Valid @ModelAttribute("candidate") Candidate candidate, BindingResult result,
            HttpServletRequest request, CandidateDAO CDao) throws IOException{ 
        List<Skill> skillset = SDao.getSkillList();
        List<String> universal_skillset = new ArrayList<>();
        for (Skill s : skillset){universal_skillset.add(s.getSkillName());}
        if(result.hasErrors())
        { return new ModelAndView ("RegisterCandidate", "UniversalSkillSet",universal_skillset); }
        else {
        HttpSession session = request.getSession();
      //  System.out.println("File "+candidate.getCv_file());
      //  File file = new File("C:\\CSyE6220ResumeUploads\\"+ session.getAttribute("login_user")+"_"+System.currentTimeMillis());
      //  candidate.getCv_file().transferTo(file);
      //  candidate.setCv(file.getAbsolutePath());
        CDao.addCandidate(candidate); 
        return new ModelAndView("RegistrationSuccess", "successMessage", "You have been successfully Registered!");
        } 
    }
}
