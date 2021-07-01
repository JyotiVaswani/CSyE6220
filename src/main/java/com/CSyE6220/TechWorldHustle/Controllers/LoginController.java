/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.Controllers;

import com.CSyE6220.TechWorldHustle.DAO.CandidateDAO;
import com.CSyE6220.TechWorldHustle.DAO.RecruiterDAO;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.Recruiter;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jyoti
 */
@Controller
public class LoginController {
   
    @Autowired
    CandidateDAO CDao;
    @Autowired
    RecruiterDAO RDao;
    
    @RequestMapping(value= "login", method=RequestMethod.GET)  
    public String showLoginPage(){    
        return "Login";  
    }
    
    
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {    
        
        HttpSession session = request.getSession(true);
      //  System.out.print(session);
        String username = request.getParameter("userName");
        String password = request.getParameter("password"); // Sanitize
        String role = request.getParameter("role");
        String pass_check;
        
        
        if (role==null)
        {
            session.setAttribute("login_session", null);
            return new ModelAndView("ErrorPage", "ErrorMsg","Invalid Login Role!");
        }
        else{
            if (role.equals("Recruiter")) {
            
                Recruiter rec = RDao.searchRecruiter(username);
                if (rec!=null)
                {pass_check = rec.getPassword();
                    if(password.equals(pass_check)) 
                        {
                            session.setAttribute("login_session",session);
                            session.setAttribute("login_user",rec.getUserId());
                            return new ModelAndView("recruiter/RecruiterHome");
                        }
                    else {session.setAttribute("login_session", null);
                        return new ModelAndView("ErrorPage", "ErrorMsg","Invalid Username and/or Password!");}
                }
                else {session.setAttribute("login_session", null);
                    return new ModelAndView("ErrorPage", "ErrorMsg","You have not registered!");}
            } else if (role.equals("Candidate")) {
                Candidate can = CDao.searchCandidate(username);
                
                if (can!=null)
                {pass_check = can.getPassword();
                    if(password.equals(pass_check)) 
                        {
                            session.setAttribute("login_session", session);
                            session.setAttribute("login_user",can.getUserId());
                            return new ModelAndView("candidate/CandidateHome");
                        }
                    else {session.setAttribute("login_session", null);
                        return new ModelAndView("ErrorPage", "ErrorMsg","Invalid Username and/or Password!");}
                }
                else {session.setAttribute("login_session", null);
                    return new ModelAndView("ErrorPage", "ErrorMsg","You have not registered!");}
            } else {
            session.setAttribute("login_session", null);
            return new ModelAndView("ErrorPage", "ErrorMsg","Invalid Login Role!");
            }
        }
    }
        
        
    @RequestMapping(value="/logout.htm", method = RequestMethod.GET)  
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        HttpSession session = request.getSession(false);
        session.setAttribute("login_session", null);
        session.setAttribute("login_user",null);
        response.sendRedirect("/TechWorldHustle/Welcome.jsp");
    }
}
