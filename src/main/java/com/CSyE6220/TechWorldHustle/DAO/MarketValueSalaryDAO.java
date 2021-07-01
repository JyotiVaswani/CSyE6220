/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.CompanyReview;
import com.CSyE6220.TechWorldHustle.pojo.IndividualRating;
import com.CSyE6220.TechWorldHustle.pojo.MarketValueSalary;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jyoti
 */
public class MarketValueSalaryDAO extends DAO{
    
        
        public void addMarketValueSalary(MarketValueSalary mvs)
	{
		beginTransaction();
		getSession().save(mvs);
		commit();
	}
	
	
	public void deleteMarketValueSalary(MarketValueSalary mvs)
	{
		beginTransaction();
		getSession().delete(mvs);
		commit();
	}
        
        public List<MarketValueSalary> getMarketValueSalaryList(String jobTitle, String company, String location)
        {
            beginTransaction();             
            Criteria criteria = getSession().createCriteria(MarketValueSalary.class);
            criteria.add(Restrictions.ilike("jobTitle", jobTitle));
            if(company.length()>0)
            {criteria.add(Restrictions.ilike("company", company));}
            if(location.length()>0)
            {criteria.add(Restrictions.ilike("location", location));}           
            criteria.addOrder(Order.desc("basePay"));
            List<MarketValueSalary> result = criteria.list(); 
            return result;
        }
        
        public Map<String, String> getAverageBasePay(String jobTitle, String company, String location)
        {
            beginTransaction();            
            Criteria criteria = getSession().createCriteria(MarketValueSalary.class);
            criteria.add(Restrictions.eq("jobTitle", jobTitle));
            if(company.length()>0)
            {criteria.add(Restrictions.ilike("company", company));}
            if(location.length()>0)
            {criteria.add(Restrictions.ilike("location", location));}
            ProjectionList projList = Projections.projectionList();
            projList.add(Projections.min("basePay"));
            projList.add(Projections.avg("basePay"));
            projList.add(Projections.max("basePay"));
            criteria.setProjection(projList);
            List<Object[]> results = criteria.list();
            Map<String, String> base_pay_aggregations= new HashMap<>();
            String min_basePay = results.get(0)[0].toString();
            String avg_basePay = results.get(0)[1].toString();
            String max_basePay = results.get(0)[2].toString();
            base_pay_aggregations.put("min_basePay",min_basePay);
            base_pay_aggregations.put("avg_basePay",avg_basePay);
            base_pay_aggregations.put("max_basePay",max_basePay);
            base_pay_aggregations.put("jobTitle",jobTitle);
            base_pay_aggregations.put("company",company);
            base_pay_aggregations.put("location",location);
            return base_pay_aggregations;   
        }
}
