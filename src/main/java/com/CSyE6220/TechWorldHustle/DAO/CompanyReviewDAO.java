/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;
import com.CSyE6220.TechWorldHustle.pojo.CompanyReview;
import com.CSyE6220.TechWorldHustle.pojo.IndividualRating;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.sql.JoinType;

/**
 *
 * @author jyoti
 */
public class CompanyReviewDAO extends DAO {
    
        public void addCompanyReview(CompanyReview cr)
	{
		beginTransaction();
		getSession().save(cr);
		commit();
	}
	
	
	public void deleteCompanyReview(CompanyReview cr)
	{
		beginTransaction();
		getSession().delete(cr);
		commit();
	}

    
        public List<CompanyReview> getCompanyReviewList(String company, String jobTitle)
        {
            beginTransaction();  
            
            Criteria criteria = getSession().createCriteria(CompanyReview.class, "cr");
            criteria.add(Restrictions.eq("cr.company", company));
            if(jobTitle.length()>0)
            {criteria.add(Restrictions.eq("cr.jobTitle", jobTitle));}
            criteria.addOrder(Order.asc("reviewDate"));
            criteria.createAlias("cr.rating", "ir");
            criteria.setProjection(Projections.projectionList()
                    .add( Projections.property("cr.pros"))
                    .add( Projections.property("cr.cons"))
                    .add( Projections.property("cr.employmentStatus"))
                    .add( Projections.property("cr.reviewDate"))
                    .add( Projections.property("cr.reviewId"))
                    .add( Projections.property("ir.overallRating"))).list();
            List<Object[]> result = criteria.list();
            List<CompanyReview> cr_result = new ArrayList<>();
            for (Object[] o : result){
            CompanyReview cmpreview = new CompanyReview();
            IndividualRating ir = new IndividualRating();
            ir.setReview(cmpreview);
            cmpreview.setRating(ir);
            cmpreview.setPros((String)o[0]);
            cmpreview.setCons((String)o[1]);
            cmpreview.setEmploymentStatus((String)o[2]);
            cmpreview.setReviewDate((Date)o[3]);
            cmpreview.setReviewId((int)o[4]);
            cmpreview.getRating().setOverallRating((double)o[5]);
            cr_result.add(cmpreview);
            }
            return cr_result;
        }
        
} 
