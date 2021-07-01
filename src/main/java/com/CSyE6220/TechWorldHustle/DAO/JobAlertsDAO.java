/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.JobAlerts;
import org.hibernate.query.Query;

/**
 *
 * @author jyoti
 */
public class JobAlertsDAO extends DAO{
    
            public void addJobAlerts(JobAlerts jobalerts)
	{
		beginTransaction();
		getSession().save(jobalerts);
		commit();
	}
	
	
	public void deleteJobAlerts(JobAlerts jobalerts)
	{
		beginTransaction();
		getSession().delete(jobalerts);
		commit();
	}
        
        
        public JobAlerts getJobAlerts(int alertId)
        {
            beginTransaction();
            JobAlerts result = getSession().get(JobAlerts.class, alertId);
            commit();
            return result;   
        }
        
    
        public Long numberOfJobAlerts()
	{
		beginTransaction();
                String hql = "Select count(*) FROM JobAlerts";
                Query query = getSession().createQuery(hql);
		System.out.println("count: "+ query);
		commit();
                return ((Long)query.uniqueResult()).longValue();
	}
    
}
