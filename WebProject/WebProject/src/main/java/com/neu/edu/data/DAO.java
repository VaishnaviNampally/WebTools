package com.neu.edu.data;

import org.hibernate.Session;

public class DAO {

	public Session getSession(){
		   return HibernateUtil.getSessionFactory().openSession();
	}
}
