/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Application;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


/**
 *
 * @author jyoti
 */
public class ApplicationDAO extends DAO{
    
        public void addApplication(Application app)
	{
		beginTransaction();
		getSession().save(app);
		commit();
	}
    
            
        public List<Application> filterJob(int jobId)
        {
            Criteria crit = getSession().createCriteria(Application.class);
            Criterion c_jobId = Restrictions.eq("jobId.jobId",jobId);
            Criterion sts_applied = Restrictions.eq("status","Applied");
            Criterion sts_processing = Restrictions.eq("status","Processing");
            LogicalExpression orExp = Restrictions.or(sts_applied, sts_processing);
            crit.add(orExp);
            crit.add(c_jobId);
            List<Application> results=crit.list();
            return results;
        }
                
                
  
        
        public void updateApplication(Application app)
	{
		beginTransaction();
		getSession().update("status", app);
                getSession().update("Remarks", app);
		commit();
	}
        
        public Application getApplication(int applicationId)
        {
            beginTransaction();
            Application result = getSession().get(Application.class, applicationId);
            commit();
            return result;   
        }
        
        public List<Application> getCandidateApplications(int candidateId)
        {
            beginTransaction();
            String hql = "FROM Application where CandidateId=:can_Id";
            Query query = getSession().createQuery(hql);
            query.setParameter("can_Id", candidateId);
            List result = query.list();
            commit();
            return result;
        }
        
}
