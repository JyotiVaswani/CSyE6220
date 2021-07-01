/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Candidate;

import com.CSyE6220.TechWorldHustle.pojo.Recruiter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author jyoti
 */
public class RecruiterDAO extends DAO{
    
        	public void addRecruiter(Recruiter r)
	{
		beginTransaction();
		getSession().save(r);
		commit();
	}
	
	
	public void deleteRecruiter(Recruiter r)
	{
		beginTransaction();
		getSession().delete(r);
		commit();
	}
	
	public Recruiter getRecruiter(int RecruiterId)
        {
            beginTransaction();
            Recruiter result = getSession().get(Recruiter.class, RecruiterId);
            commit();
            return result;
            
        }
        
        
	public Recruiter searchRecruiter(String Username)
	{
            beginTransaction();
                Criteria cr = getSession().createCriteria(Recruiter.class);
                cr.add(Restrictions.like("userName",Username));
		Recruiter r = (Recruiter) cr.uniqueResult();
		commit();
		return r;
	}
    
        public void updateRecruiter(Recruiter r)
	{
		beginTransaction();
		getSession().saveOrUpdate(r);
		commit();
	}
}
