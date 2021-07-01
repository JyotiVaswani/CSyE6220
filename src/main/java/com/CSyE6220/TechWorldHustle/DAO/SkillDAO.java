/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

import static com.CSyE6220.TechWorldHustle.DAO.DAO.getSession;
import com.CSyE6220.TechWorldHustle.pojo.Job;
import com.CSyE6220.TechWorldHustle.pojo.Skill;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.hibernate.query.Query;

/**
 *
 * @author jyoti
 */
public class SkillDAO extends DAO{
    
	public List<Skill> getSkillList()
        {
            beginTransaction();
            String hql = "FROM Skill";
            Query query = getSession().createQuery(hql);
            List result = query.list();
            commit();
            return result;   
        }
        
        public Skill getSkillFromName(String name)
        {
            beginTransaction();
            String hql = "FROM Skill where SkillName=:name";
            Query query = getSession().createQuery(hql);
            query.setParameter("name", name);
            Skill s = (Skill) query.uniqueResult();
            commit();
            return s;
        }
}
