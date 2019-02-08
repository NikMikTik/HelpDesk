package com.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.util.HibernateUtil;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User{


	
	
	public void Enter()
	{Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query q=ses.createQuery("from User");
	List<User> u=new ArrayList<>();
	Admin aa=new Admin();
	Department dd=new Department();
	Department de=new Department();
	Department df=new Department();
	aa.setUser_name("admin");
	aa.setPassword("admin");
	aa.setPermission(3);
	ses.save(aa);
	dd.setDept_id(1);
	dd.setDept_name("HR");
	dd.setValue(1);
	
	de.setDept_id(2);
	de.setDept_name("TECH");
	de.setValue(1);
	
	df.setDept_id(3);
	df.setDept_name("SUPPORT");
	df.setValue(1);
	ses.save(dd);
	ses.save(de);
	ses.save(df);
	
	tx.commit();}
	
	
	}

	


