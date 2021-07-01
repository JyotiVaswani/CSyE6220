/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;

import com.CSyE6220.TechWorldHustle.DAO.ApplicationDAO;
import com.CSyE6220.TechWorldHustle.DAO.CandidateDAO;
import com.CSyE6220.TechWorldHustle.DAO.IndividualRatingDAO;
import com.CSyE6220.TechWorldHustle.DAO.JobDAO;
import com.CSyE6220.TechWorldHustle.DAO.RecruiterDAO;
import com.CSyE6220.TechWorldHustle.DAO.SkillDAO;
import com.CSyE6220.TechWorldHustle.DAO.JobAlertsDAO;
import com.CSyE6220.TechWorldHustle.pojo.Application;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;
import com.CSyE6220.TechWorldHustle.pojo.GroupedRatingDTO;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.JobAlerts;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import com.CSyE6220.TechWorldHustle.pojo.UploadedFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jyoti
 */
@Controller
public class CandidateActionController {
    
       
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
    @Autowired
    JobAlertsDAO JADao;
    @Autowired
    IndividualRatingDAO IRDao;
    
    @RequestMapping(value="/candidate/searchJobs.htm", method = RequestMethod.GET)  
    public ModelAndView fetchJobs(){  
        List <Job> job_list = JDao.getOpenJobList();
        return new ModelAndView("candidate/displayJobs", "JobList", job_list);
    }
    
    @RequestMapping(value="/candidate/CandidateHome.htm", method = RequestMethod.GET)  
    public String goHomepage()
    {return "candidate/CandidateHome";}
    
    @RequestMapping(value="/candidate/advancedJobSearchParameters.htm", method = RequestMethod.GET)  
    public ModelAndView advancedSearchParameters(ModelMap model, Job job){ 
        List<Skill> skillset = SDao.getSkillList();
        List<String> universal_skillset = new ArrayList<>();
        for (Skill s : skillset){universal_skillset.add(s.getSkillName());}
        job.setCompany("No preference");
        job.setJobTitle("No preference");
        job.setLocation("No preference");
        job.setSalaryOffered(0.0);
        return new ModelAndView("candidate/advancedJobSearchParameters","UniversalSkillSet",universal_skillset);
    }

    @RequestMapping(value="/candidate/uploadcv.htm", method = RequestMethod.GET)
    public String uploadPage() {  
        System.out.println("Enter Get of Upload");
    return "candidate/uploadcv";
    }
    
    @RequestMapping(value="/candidate/uploadcv.htm", method = RequestMethod.POST)
    public void saveFile(HttpServletRequest request, Object o) {
        
        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setMultipartFile((MultipartFile)o);
        System.out.println("Enter Post Controller");
        HttpSession session = request.getSession();
        MultipartFile multipartFile = uploadedFile.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();
        System.out.println("Absolute path:  "+fileName);
        try {
            File file = new File("C:\\CSyE6220ResumeUploads\\"+ session.getAttribute("login_user")+"_"+System.currentTimeMillis());
            System.out.println("Absolute path:  "+file.getAbsolutePath());
            
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
    @RequestMapping(value="/candidate/advancedJobSearchParameters.htm", method = RequestMethod.POST)  
    public ModelAndView advancedJobSearch(@ModelAttribute("job") Job job, BindingResult result,HttpServletRequest request){
        if (request.getParameter("jobaction").equals("addForAlerts"))
        {
            HttpSession session = request.getSession();
            JobAlerts job_alert = new JobAlerts();
            job_alert.setUserId(CDao.getCandidate((int)session.getAttribute("login_user")));
            job_alert.setJobTitle(job.getJobTitle());
            job_alert.setLocation(job.getLocation());
            job_alert.setMinSalary(job.getSalaryOffered());
            job_alert.setAlertName(session.getAttribute("login_user")+"_"+System.currentTimeMillis());
            JADao.addJobAlerts(job_alert);
            return new ModelAndView("candidate/ActvitySuccess", "successMessage", "Job Alert has been activated!");}
        else{
            String location = job.getLocation();
            String jobTitle = job.getJobTitle();
            String company = job.getCompany();
            double salaryOffered = job.getSalaryOffered();
            Date startDate = job.getStartDate();
            String primary_skills = job.getPrimary_skills();
            List <Job> job_list = JDao.filterAdvancedSearch(location, jobTitle, company, salaryOffered,startDate, primary_skills);
            return new ModelAndView("candidate/displayJobs", "JobList", job_list);}
    }
    
    
    @RequestMapping(value="/candidate/ApplyJob.htm", method = RequestMethod.GET)  
    public ModelAndView ApplyJobs(HttpServletRequest request){  
        HttpSession session = request.getSession();
        Application app = new Application();
        app.setJobId(JDao.getJob(Integer.parseInt(request.getParameter("jid"))));
        app.setRecruiterId(RDao.getRecruiter(Integer.parseInt(request.getParameter("rid"))));
        app.setCandidateId(CDao.getCandidate((int)session.getAttribute("login_user")));
        app.setApplicationDate(new Date()); 
        app.setStatus("Applied");
        AppDao.addApplication(app);
        return new ModelAndView("candidate/ActvitySuccess", "successMessage", "Application Submitted!");
    }
    
    @RequestMapping(value="/candidate/checkApplications.htm", method = RequestMethod.GET)  
    public ModelAndView checkApplications(HttpServletRequest request){ 
        HttpSession session = request.getSession();
        List <Application> app_list = AppDao.getCandidateApplications((int)session.getAttribute("login_user"));
        return new ModelAndView("candidate/checkApplications", "ApplicationList", app_list);
    }
    
    @RequestMapping(value="/candidate/withdrawApplication.htm", method = RequestMethod.GET)  
    public ModelAndView withdrawApplications(HttpServletRequest request){ 
        Application app_update = AppDao.getApplication(Integer.parseInt(request.getParameter("appid")));
        app_update.setStatus("Withdrew");
        AppDao.updateApplication(app_update);
        return new ModelAndView("candidate/ActvitySuccess", "successMessage", "Application has been withdrawn!");
    }
    
    @RequestMapping(value="/candidate/RankingBoard.htm", method = RequestMethod.GET)  
    public ModelAndView showRankingBoard(HttpServletRequest request){ 
        List<GroupedRatingDTO> results = IRDao.getTopCompanyIndividualRating();
        return new ModelAndView("candidate/RankingBoard", "RatingRanks", results);
    }
    
    
    @RequestMapping(value="/candidate/updateProfile.htm", method = RequestMethod.GET)  
    public ModelAndView updateCandidateProfile(ModelMap model, Candidate candidate, HttpServletRequest request){ 
        HttpSession session = request.getSession();
        List<Skill> skillset = SDao.getSkillList();
        List<String> universal_skillset = new ArrayList<>();
        for (Skill s : skillset){universal_skillset.add(s.getSkillName());}
        Candidate c = CDao.getCandidate((int)session.getAttribute("login_user"));
        candidate.setFirstName(c.getFirstName());
        candidate.setLastName(c.getLastName());
        candidate.setGender(c.getGender());
        candidate.setUserName(c.getUserName());
        candidate.setDob(c.getDob());
        candidate.setContact(c.getContact());
        candidate.setEmploymentTypePreference(c.getEmploymentTypePreference());
        candidate.setCurrent_Company(c.getCurrent_Company());
        candidate.setCurrent_JobTitle(c.getCurrent_JobTitle());
        candidate.setCurrent_location(c.getCurrent_location());
        candidate.setPrimary_skills(c.getPrimary_skills());
        candidate.setPassword(c.getPassword());
        return new ModelAndView("RegisterCandidate","UniversalSkillSet",universal_skillset);
    }
    
    
    @RequestMapping(value="/candidate/updateProfile.htm",method = RequestMethod.POST)  
    public ModelAndView updateCandidateProfile(@ModelAttribute("candidate") Candidate candidate, BindingResult result, HttpServletRequest request, CandidateDAO CDao){  
        Candidate updateCandidate = new Candidate();
        updateCandidate.setPrimary_skills(candidate.getPrimary_skills());
        updateCandidate.setContact(candidate.getContact());
        updateCandidate.setCurrent_Company(candidate.getCurrent_Company());
        updateCandidate.setCurrent_JobTitle(candidate.getCurrent_JobTitle());
        updateCandidate.setEmploymentTypePreference(candidate.getEmploymentTypePreference());
        updateCandidate.setCurrent_location(candidate.getCurrent_location());
        updateCandidate.setCv(request.getParameter("cv"));
        updateCandidate.setPassword(candidate.getPassword());
        CDao.updateCandidate(updateCandidate); 
        return new ModelAndView("RegistrationSuccess", "successMessage", "Your profile has been updated");
    }
    
}
