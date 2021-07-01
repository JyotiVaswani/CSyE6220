/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author jyoti
 */
public class CandidateDAO extends DAO{
    
    	public void addCandidate(Candidate c)
	{
		beginTransaction();
		getSession().save(c);
		commit();
	}
	
	
	public void deleteCandidate(Candidate c)
	{
		beginTransaction();
		getSession().delete(c);
		commit();
	}
	
	
	public Candidate searchCandidate(String Username)
	{
		beginTransaction();
                Criteria cr = getSession().createCriteria(Candidate.class);
                cr.add(Restrictions.like("userName",Username));
		Candidate c = (Candidate) cr.uniqueResult();
		commit();
		return c;
	}
        
        public Candidate getCandidate(int CandidateId)
        {
            beginTransaction();
            Candidate result = getSession().get(Candidate.class, CandidateId);
            commit();
            return result;
            
        }
        
        public List<Candidate> getCandidateList()
        {
            beginTransaction();
            String hql = "FROM Candidate";
            Query query = getSession().createQuery(hql);
            List result = query.list();
            commit();
            return result;   
        }
    
        public void updateCandidate(Candidate c)
	{
		beginTransaction();
		getSession().saveOrUpdate(c);
		commit();
	}
        
        public List<Candidate> getCandidateEmploymentTypeList(String preference)
        {
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Candidate.class);
            criteria.add(Restrictions.eq("employmentTypePreference",preference )); // pojo class property name
            List result = criteria.list();
            commit();
            return result;
        }
        
        public List<Candidate> filterAdvancedSearch(String location, String jobTitle,String primary_skills, String employmentTypePreference)
        {
            beginTransaction();            
            Criteria criteria = getSession().createCriteria(Candidate.class);
            if(!location.equals("No preference"))
               {criteria.add(Restrictions.ilike("location",location,MatchMode.ANYWHERE)); }
            if(!jobTitle.equals("No preference"))
               {criteria.add(Restrictions.ilike("jobTitle",jobTitle,MatchMode.ANYWHERE)); }
            if(!primary_skills.equals("No preference"))
               {criteria.add(Restrictions.ilike("primary_skills",primary_skills,MatchMode.ANYWHERE)); }
            if(!employmentTypePreference.equals("No preference"))
               {criteria.add(Restrictions.eq("employmentTypePreference",employmentTypePreference)); }
            List result = criteria.list();
            commit();
            System.out.println("Result:  "+result);
            return result;
        }
        
}

