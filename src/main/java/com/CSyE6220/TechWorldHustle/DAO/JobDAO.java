/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.Recruiter;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author jyoti
 */
public class JobDAO extends DAO{
    
        public void addJob(Job j)
	{
		beginTransaction();
		getSession().save(j);
		commit();
	}
	
	
	public void deleteJob(Job j)
	{
                beginTransaction();
		getSession().delete(j);
		commit();
	}
        
        public void updateJob(Job j)
	{
		beginTransaction();
		getSession().saveOrUpdate(j);
		commit();
	}
	
	public List<Job> getJobList()
        {
            beginTransaction();
            String hql = "FROM Job";
            Query query = getSession().createQuery(hql);
            List result = query.list();
            commit();
            return result;   
        }
        
        public Job getJob(int jobId)
        {
            beginTransaction();
            Job result = getSession().get(Job.class, jobId);
            commit();
            return result;   
        }
        
        
        public List<Job> getOpenJobList()
        {
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Job.class);
            criteria.add(Restrictions.eq("status", "OPEN")); // pojo class property name
            List result = criteria.list();
            commit();
            return result;
        }
    
        public List<Job> filterRecruiter(int Rec_Id)
        {
            beginTransaction();
            String hql = "FROM Job where RecruiterId=:RecId";
            Query query = getSession().createQuery(hql);
            query.setParameter("RecId", Rec_Id);
            List result = query.list();
            commit();
            return result;
        }
        
        public List<Job> filterAdvancedSearch(String location, String jobTitle, String company, 
        double salaryOffered, Date startDate,String primary_skills)
        {
            beginTransaction();            
            Criteria criteria = getSession().createCriteria(Job.class, "j");
            
            criteria.add(Restrictions.eq("status", "OPEN"));
            if(!location.equals("No preference"))
               {criteria.add(Restrictions.ilike("location",location,MatchMode.ANYWHERE)); }
            if(!jobTitle.equals("No preference"))
               {criteria.add(Restrictions.ilike("jobTitle",jobTitle,MatchMode.ANYWHERE)); }
            if(!company.equals("No preference"))
               {criteria.add(Restrictions.ilike("company",company,MatchMode.ANYWHERE)); }
            if(salaryOffered!=0.0)
               {
                   criteria.add(Restrictions.gt("salaryOffered",salaryOffered));
                   criteria.addOrder(Order.desc("salaryOffered"));
               }
            if((startDate!=null) && (startDate.compareTo(new Date()))>=0)
               {
                   criteria.add(Restrictions.gt("startDate",startDate));
                   criteria.addOrder(Order.asc("startDate"));
               }
            if(!primary_skills.equals("No preference"))
                {criteria.add(Restrictions.ilike("primary_skills", primary_skills, MatchMode.ANYWHERE));}
            List result = criteria.list();
            commit();
            System.out.println("Result:  "+result);
            return result;
        }
    
        public List<Job> JobBasedOnAlerts(String jobTitle, String location, double sal)
        {
            beginTransaction();
            Criteria crit = getSession().createCriteria(Job.class);
            Job exampleJob = new Job();
            exampleJob.setJobTitle(jobTitle);
            exampleJob.setLocation(location);
            exampleJob.setSalaryOffered(sal);
            Example example = Example.create(exampleJob);
            if(jobTitle.equals("No preference"))
               {example.excludeProperty("jobTitle"); }
            if(location.equals("No preference"))
               {example.excludeProperty("location"); }
            if(sal==0.0)
               {example.excludeProperty("salaryOffered");}
            example.excludeZeroes();
            crit.add(example);
            List<Job> results = crit.list();
            commit();
            return results;
        }
            
    
}
