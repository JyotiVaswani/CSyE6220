/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CSyE6220.TechWorldHustle.Controllers;
import com.CSyE6220.TechWorldHustle.DAO.CompanyDAO;
import com.CSyE6220.TechWorldHustle.DAO.MarketValueSalaryDAO;
import com.CSyE6220.TechWorldHustle.pojo.Application;
import com.CSyE6220.TechWorldHustle.pojo.Company;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.MarketValueSalary;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class MarketValueSalaryController {
    
    @Autowired
    CompanyDAO ComDao;
    
    @Autowired
    MarketValueSalaryDAO MVSDao;
    
    @RequestMapping(value="/candidate/addMarketValueSalary.htm", method = RequestMethod.GET)  
    public ModelAndView addSalaryForm(ModelMap model, MarketValueSalary marketValueSalary){ 
        List<Company> companyset = ComDao.getCompanyList();
        List<String> universal_companyset = new ArrayList<>();
        for (Company c : companyset){universal_companyset.add(c.getCompanyName());}
        return new ModelAndView("candidate/addMarketValueSalary", "UniversalCompanySet", universal_companyset);
    }
    
    @RequestMapping(value="/candidate/addMarketValueSalary.htm", method = RequestMethod.POST)  
    public ModelAndView addSalary(@ModelAttribute("marketValueSalary") MarketValueSalary marketValueSalary, BindingResult result,HttpServletRequest request){ 
        MVSDao.addMarketValueSalary(marketValueSalary);
        return new ModelAndView("candidate/ActvitySuccess", "successMessage", "Thank you for valuable data. Your Salary review has been added!");
    }
    
    @RequestMapping(value="/candidate/avgMarketValueSalary.htm", method = RequestMethod.POST)  
    public ModelAndView avgMarketValueSalarySalary(HttpServletRequest request){ 
        String jobTitle = request.getParameter("jobTitle");
        String company = request.getParameter("company");
        String location = request.getParameter("location");
        Map<String, String> mvs = MVSDao.getAverageBasePay(jobTitle,company,location);
        return new ModelAndView("candidate/showAvgSalaries", "AvgSalary",mvs);
    }
    
    @RequestMapping(value="/candidate/showMarketValueSalaries.htm", method = RequestMethod.POST)  
    public ModelAndView listMarketValueSalary(HttpServletRequest request){ 
        String jobTitle = request.getParameter("jobTitle");
        String company = request.getParameter("company");
        String location = request.getParameter("location");
        List<MarketValueSalary> mvs = MVSDao.getMarketValueSalaryList(jobTitle,company,location);
        return new ModelAndView("candidate/showSalaryReports", "SalaryReports",mvs);
    }
}
