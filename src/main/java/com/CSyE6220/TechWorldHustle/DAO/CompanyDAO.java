/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Company;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author jyoti
 */
public class CompanyDAO extends DAO{
    
    	public List<Company> getCompanyList()
        {
            beginTransaction();
            String hql = "FROM Company";
            Query query = getSession().createQuery(hql);
            List result = query.list();
            commit();
            return result;   
        }
}
