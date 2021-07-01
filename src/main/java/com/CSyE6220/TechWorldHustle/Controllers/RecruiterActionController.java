/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;


import com.CSyE6220.TechWorldHustle.DAO.ApplicationDAO;
import com.CSyE6220.TechWorldHustle.DAO.CandidateDAO;
import com.CSyE6220.TechWorldHustle.DAO.JobDAO;
import com.CSyE6220.TechWorldHustle.DAO.RecruiterDAO;
import com.CSyE6220.TechWorldHustle.DAO.SkillDAO;
import com.CSyE6220.TechWorldHustle.pojo.Application;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.JobAlerts;
import com.CSyE6220.TechWorldHustle.pojo.Recruiter;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author jyoti
 */
@Controller
public class RecruiterActionController {
    
    @Autowired
    CandidateDAO CDao;
    
    @Autowired
    RecruiterDAO RDao;
    
    @Autowired
    JobDAO JDao;
    
    @Autowired
    ApplicationDAO AppDao;
    
    @Autowired
    SkillDAO SDao;
   
    @RequestMapping(value= "/recruiter/AddJobPosting.htm", method=RequestMethod.GET)  
    public ModelAndView showForm(ModelMap model, Job job, HttpServletRequest request){ 
        List<Skill> skillset = SDao.getSkillList();
        request.setAttribute("UniversalSkillSet",skillset);
        job.setStatus("OPEN");
        return new ModelAndView("recruiter/AddUpdateJobPosting");  
    }
  
    @RequestMapping(value="/recruiter/AddJobPosting.htm", method = RequestMethod.POST)  
    public ModelAndView save(@Valid @ModelAttribute("job") Job job, BindingResult result,HttpServletRequest request){  
        List<Skill> skillset = SDao.getSkillList();
        request.setAttribute("UniversalSkillSet",skillset);
        if(result.hasErrors())
        { return new ModelAndView ("/recruiter/AddUpdateJobPosting"); }
        else 
        {
            HttpSession session = request.getSession();
            job.setRecId(RDao.getRecruiter((int)session.getAttribute("login_user"))); 
            JDao.addJob(job); 
            return new ModelAndView("recruiter/JobActivitySuccess", "successMessage", "Job has been posted successfully!");
        } 
    }
    
    @RequestMapping(value="/recruiter/ViewJobs.htm", method = RequestMethod.GET)  
    public ModelAndView fetchJobs(HttpServletRequest request){  
        HttpSession session = request.getSession();
        List <Job> job_list = JDao.filterRecruiter((int)session.getAttribute("login_user")); 
        return new ModelAndView("recruiter/ViewJobs", "JobPosted", job_list);
    }
    
    @RequestMapping(value="/recruiter/JobApplications.htm", method = RequestMethod.GET)  
    public ModelAndView fetchApplications(HttpServletRequest request){  
        List <Application> app_list = AppDao.filterJob(Integer.parseInt(request.getParameter("jid"))); 
        return new ModelAndView("recruiter/ViewApplications", "ApplicationsReceived", app_list);
    }
    
    
    @RequestMapping(value="/recruiter/updateApplication.htm", method = RequestMethod.GET)  
    public ModelAndView updateApplication(HttpServletRequest request){  
        Application app_update = AppDao.getApplication(Integer.parseInt(request.getParameter("appid")));
        app_update.setStatus(request.getParameter("sts"));
        app_update.setRemarks(request.getParameter("remarks"));
        AppDao.updateApplication(app_update);
        return new ModelAndView("recruiter/JobActivitySuccess", "successMessage", "Application has been updated!");
    }
    
    @RequestMapping(value="/recruiter/searchCandidates.htm", method = RequestMethod.GET)  
    public ModelAndView fetchJobs(){  
        List <Candidate> can_list = CDao.getCandidateList();
        return new ModelAndView("recruiter/displayCandidates", "CandidateList", can_list);
    }
    
    @RequestMapping(value="/recruiter/RecruiterHome.htm", method = RequestMethod.GET)  
    public String goHomepage()
    {return "recruiter/RecruiterHome";}
    
        
    @RequestMapping(value="/recruiter/advancedCandidateSearchParameters.htm", method = RequestMethod.GET)  
    public ModelAndView advancedCandidateSearchParameters(ModelMap model, Candidate candidate){ 
        List<Skill> skillset = SDao.getSkillList();
        List<String> universal_skillset = new ArrayList<>();
        for (Skill s : skillset){universal_skillset.add(s.getSkillName());}
        candidate.setCurrent_location("No preference");
        candidate.setEmploymentTypePreference("No preference");
        candidate.setCurrent_JobTitle("No preference");
        return new ModelAndView("recruiter/advancedCandidateSearchParameters","UniversalSkillSet",universal_skillset);
    }
  
    @RequestMapping(value="/recruiter/advancedCandidateSearchParameters.htm", method = RequestMethod.POST)  
    public ModelAndView advancedCandidateSearch(@ModelAttribute("candidate") Candidate candidate, BindingResult result,HttpServletRequest request){
        
            HttpSession session = request.getSession();
            String location = candidate.getCurrent_location();
            String jobTitle = candidate.getCurrent_JobTitle();
            String employmentTypePreference = candidate.getEmploymentTypePreference();
            String primary_skills = candidate.getPrimary_skills();
            List<Candidate> suitableCan = CDao.filterAdvancedSearch(location, jobTitle, primary_skills, employmentTypePreference);
            return new ModelAndView("recruiter/displayCandidates", "CandidateList", suitableCan);
            }
  
    @RequestMapping(value= "/recruiter/updateJobPosting.htm", method=RequestMethod.GET)  
    public ModelAndView updateJobPosting(ModelMap model, Job job, HttpServletRequest request){ 
        List<Skill> skillset = SDao.getSkillList();
        List<String> universal_skillset = new ArrayList<>();
        for (Skill s : skillset){universal_skillset.add(s.getSkillName());}
        Job j = JDao.getJob(Integer.parseInt(request.getParameter("jid")));
        job.setJobTitle(j.getJobTitle());
        job.setCompany(j.getCompany());
        job.setLocation(j.getLocation());
        job.setJobDescription(j.getJobDescription());
        job.setPrimary_skills(j.getPrimary_skills());
        job.setSalaryOffered(j.getSalaryOffered());
        job.setStartDate(j.getStartDate());
        job.setStatus("OPEN");
        return new ModelAndView("recruiter/AddUpdateJobPosting", "UniversalSkillSet",universal_skillset );  
    }
  
    @RequestMapping(value="/recruiter/updateJobPosting.htm", method = RequestMethod.POST)  
    public ModelAndView updateJobPosting(@ModelAttribute("job") Job job, BindingResult result,HttpServletRequest request){  
        HttpSession session = request.getSession();       
        Job updatejob = new Job();
        updatejob.setRecId(RDao.getRecruiter((int)session.getAttribute("login_user")));
        updatejob.setJobDescription(job.getJobDescription());
        updatejob.setLocation(job.getLocation());
        updatejob.setPrimary_skills(job.getPrimary_skills());
        updatejob.setStartDate(job.getStartDate());
        updatejob.setSalaryOffered(job.getSalaryOffered());
        JDao.updateJob(updatejob);
        return new ModelAndView("recruiter/JobActivitySuccess", "successMessage", "Job has been updated successfully!");
    }
        
    @RequestMapping(value="/recruiter/updateProfile.htm", method = RequestMethod.GET)  
    public ModelAndView updateRecruiterProfile(ModelMap model, Recruiter recruiter, HttpServletRequest request){ 
        HttpSession session = request.getSession();
        Recruiter r = RDao.getRecruiter((int)session.getAttribute("login_user"));
        recruiter.setFirstName(r.getFirstName());
        recruiter.setLastName(r.getLastName());
        recruiter.setGender(r.getGender());
        recruiter.setUserName(r.getUserName());
        recruiter.setDob(r.getDob());
        recruiter.setContact(r.getContact());
        recruiter.setCompany(r.getCompany());
        recruiter.setCurrent_location(r.getCurrent_location());
        recruiter.setPassword(r.getPassword());
        return new ModelAndView("RegisterRecruiter");
    }
    
    
    @RequestMapping(value="/recruiter/updateProfile.htm",method = RequestMethod.POST)  
    public ModelAndView updateRecruiterProfile(@ModelAttribute("recruiter") Recruiter recruiter, BindingResult result, HttpServletRequest request){  
        Recruiter updateRecruiter = new Recruiter();
        updateRecruiter.setContact(recruiter.getContact());
        updateRecruiter.setCompany(recruiter.getCompany());
        updateRecruiter.setCurrent_location(recruiter.getCurrent_location());
        updateRecruiter.setPassword(recruiter.getPassword());
        RDao.updateRecruiter(updateRecruiter); 
        return new ModelAndView("RegistrationSuccess", "successMessage", "Your profile has been updated");
    }
}
