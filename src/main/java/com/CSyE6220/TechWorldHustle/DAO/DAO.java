/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.DAO;

/**
 *
 * @author jyoti
 */
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {

	private static final Logger Log = Logger.getAnonymousLogger(); 
	private static final ThreadLocal session = new ThreadLocal();
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    
	public DAO() {}
	
	public static Session getSession()
	{
		Session session = (Session) DAO.session.get();
		if (session==null)
		{
			session = sessionFactory.openSession();
			DAO.session.set(session);
		}
		return session;
	}
	
	protected void beginTransaction()
	{
		getSession().beginTransaction();
	}
	
	protected void commit()
	{
		getSession().getTransaction().commit();
	}
	
	protected void rollback()
	{
		getSession().getTransaction().rollback();
		getSession().close(); //close 
		DAO.session.set(null); //remove session from ThreadLocal
	}
	
	public static void close()
	{
		getSession().close();
		DAO.session.set(null);
	}
	
	
}

