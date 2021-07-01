/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.WalkInDrive;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jyoti
 */
public class WalkInDriveDAO extends DAO{
    
            public void addWalkInDrive(WalkInDrive w)
	{
		beginTransaction();
		getSession().save(w);
		commit();
	}
	
	
	public void deleteWalkInDrive(WalkInDrive w)
	{
                beginTransaction();
		getSession().delete(w);
		commit();
	}
        
        public void updateWalkInDrive(WalkInDrive w)
	{
		beginTransaction();
		getSession().saveOrUpdate(w);
		commit();
	}
        
        public List<WalkInDrive> getWalkInDriveList()
        {
            beginTransaction();
            Criteria criteria = getSession().createCriteria(WalkInDrive.class);
            criteria.add(Restrictions.gt("driveDate", new Date()));
            criteria.addOrder(Order.asc("driveDate")); // pojo class property name
            List result = criteria.list();
            commit();
            return result;
        }
}
