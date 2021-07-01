/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CSyE6220.TechWorldHustle.Controllers;
import com.CSyE6220.TechWorldHustle.DAO.CompanyDAO;
import com.CSyE6220.TechWorldHustle.DAO.CompanyReviewDAO;
import com.CSyE6220.TechWorldHustle.DAO.IndividualRatingDAO;
import com.CSyE6220.TechWorldHustle.pojo.Company;
import com.CSyE6220.TechWorldHustle.pojo.CompanyReview;
import com.CSyE6220.TechWorldHustle.pojo.IndividualRating;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
public class ReviewController {
    
        
    @Autowired
    CompanyDAO ComDao;
    @Autowired
    CompanyReviewDAO CRDao;
    @Autowired
    IndividualRatingDAO IRDao;
    
    @RequestMapping(value="/candidate/addCompanyReview.htm", method=RequestMethod.GET)  
    public ModelAndView addCompanyReviewForm(ModelMap model, CompanyReview companyReview){ 
        List<Company> companyset = ComDao.getCompanyList();
        List<String> universal_companyset = new ArrayList<>();
        for (Company c : companyset){universal_companyset.add(c.getCompanyName());}
        return new ModelAndView("candidate/addCompanyReview", "UniversalCompanySet",universal_companyset); 
    }
   
    @RequestMapping(value="/candidate/addCompanyReview.htm", method = RequestMethod.POST)  
    public ModelAndView addCompanyReview(@ModelAttribute("companyReview") CompanyReview companyReview, BindingResult result,
     HttpServletRequest request){  
        companyReview.setReviewDate(new Date());
        IndividualRating ir = new IndividualRating();
        ir.setReviewId(companyReview.getReviewId());
        double co = companyReview.getRating().getCareerOpportunities();
        ir.setCareerOpportunities(co);
        double cb = companyReview.getRating().getCompensationAndBenefits();
        ir.setCompensationAndBenefits(cb);
        double wlb = companyReview.getRating().getWorkLifeBalance();
        ir.setWorkLifeBalance(wlb);
        double sm = companyReview.getRating().getSeniorManagement();
        ir.setSeniorManagement(sm);
        double wc = companyReview.getRating().getWorkCulture();
        ir.setWorkCulture(wc);
        double ve = companyReview.getRating().getValuesEmployee();
        ir.setValuesEmployee(ve);
        double prf = companyReview.getRating().getPercentRecommendToAFriend();
        ir.setPercentRecommendToAFriend(prf);
        double bo = companyReview.getRating().getBusinessOutlook();
        ir.setBusinessOutlook(bo);
        double ca = companyReview.getRating().getCeoApproval();
        ir.setCeoApproval(ca);
        double overallRating = (co+cb+wlb+sm+wc+ve+bo+ca)/8;
        ir.setOverallRating(overallRating);
        ir.setReview(companyReview);
        companyReview.setRating(ir);
      
        CRDao.addCompanyReview(companyReview);
        return new ModelAndView("candidate/ActvitySuccess", "successMessage", "Review has been added successfully!");
    } 
    
    @RequestMapping(value="/candidate/showAvgCompanyRating.htm", method=RequestMethod.POST)  
    public ModelAndView showAverageRating(HttpServletRequest request){ 
        String company = request.getParameter("company");
        List<IndividualRating> avg_ratings = IRDao.getAverageIndividualRating(company);
        return new ModelAndView("candidate/showCompanyRating", "Rating",avg_ratings); 
    }
    
    
    @RequestMapping(value="/candidate/showCompanyReviews.htm", method=RequestMethod.POST)  
    public ModelAndView showCompanyReviews(HttpServletRequest request){ 
        
        String company = request.getParameter("company");
        String jobtitle = request.getParameter("jobtitle");
        List<CompanyReview> cmp_reviews;
        cmp_reviews = CRDao.getCompanyReviewList(company,jobtitle);
        return new ModelAndView("candidate/showCompanyReviews","CompanyReviews",cmp_reviews); 
    }
    
    @RequestMapping(value="/candidate/showDetailedCompanyRating.htm", method=RequestMethod.POST)  
    public ModelAndView showDetailedRating(HttpServletRequest request){ 
        String reviewId = request.getParameter("rId");
        List<IndividualRating> detailed_ratings = IRDao.getIndividualRatingReviewId(Integer.parseInt(reviewId));
        return new ModelAndView("candidate/showCompanyRating", "Rating",detailed_ratings); 
    }
    
    
}
