package com.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.util.HibernateUtil;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends User{
	
	private long Phone_no;
	private String email;

	public Customer(int user_id, String user_name, String password, int permission, long phone_no, String email) {
		super(user_id, user_name, password, permission);
		Phone_no = phone_no;
		this.email = email;
	}
	public long getPhone_no() {
		return Phone_no;
	}
	public void setPhone_no(long phone_no) {
		Phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int user_id, String user_name, String password, int permission) {
		super(user_id, user_name, password, permission);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [Phone_no=" + Phone_no + ", email=" + email + "]";
	}

	
	
	
	public boolean enter( String user_name, long phone_no, String email, String password)
	{boolean value=false;
	Customer cc=new Customer();
	cc.setUser_name(user_name);
	cc.setEmail(email);
	cc.setPassword(password);
	cc.setPhone_no(phone_no);
	cc.setPermission(1);
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	ses.save(cc);
	tx.commit();
	ses.close();
	System.out.println("CUSTOMER ENTERED");
	value=true;
	return value;}
	
	public List<Customer> showCustomer(){
		List<Customer> c=new ArrayList<>();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query q1=session.createQuery("from Customer");
		List<Customer> li=q1.list();
		for (Customer u : li) {
			c.add(u);
			
		}
		
		return c;
		
	}
	
	public boolean delC(int qId)
	{boolean v=false;
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Customer");
	List<Customer> li=qqq.list();
	try{for (Customer query : li) {
		if(qId==query.getUser_id())
		{	
			System.out.println("qid"+qId);
			org.hibernate.Query q=ses.createQuery("delete from Customer where user_id= :qId");
		q.setParameter("qId", qId);
		System.out.println("q"+qId);
		System.out.println("q"+q);
		int result = q.executeUpdate();
		if(result!=0)
		{System.out.println("YeS Removed");
		li.remove(query);v=true;
		tx.commit();
		ses.close();}
		}
			}}catch (Exception e) {
				System.out.println("Deleted");
			}
	
		return v;}
		
}
