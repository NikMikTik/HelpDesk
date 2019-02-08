package com.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.util.HibernateUtil;


@Entity
@DiscriminatorValue("Staff")
public class Staff extends User{
	
	
	private String email;
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department dept;
	
			
	public Staff() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Staff(int user_id, String user_name, String password, int permission, String email, Department dept) {
		super(user_id, user_name, password, permission);
		this.email = email;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Staff [email=" + email + ", dept=" + dept + "]";
	}

	public int enter( String user_name,String dept_name, String email, String password)
	{int value=0; int Did=0, v=0;
	Department d= new Department();
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	Query q=ses.createQuery("from Department");
	List<Department> li= q.list();
	for (Department department : li) {
		if(dept_name.equals(department.getDept_name())){
			Did=department.getDept_id();
			v=department.getValue();
			
		}
		else{
		     System.out.println("department not correct");
		}
	}
	
	d.setDept_id(Did);
	d.setDept_name(dept_name);
	d.setValue(v);
	Staff ss=new Staff();
	ss.setUser_name(user_name);
	ss.setEmail(email);
	ss.setPassword(password);
	ss.setDept(d);
	
	
	ss.setPermission(2);
	
	ses.save(ss);
	tx.commit();
	ses.close();
	System.out.println("STAFF ENTERED");
value=1;
	return value;}
	
	
	public List<Staff> showStaff(){
		List<Staff> s=new ArrayList<>();
		Session ses =HibernateUtil.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		Query q=ses.createQuery("from Staff");
		List<Staff> li=q.list();
		for (Staff u : li) {
			s.add(u);
			
		}
		return s;
	}
	
	public boolean delS(int qId)
	{boolean v=false;
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Staff");
	List<Staff> li=qqq.list();
	try{for (Staff query : li) {
		if(qId==query.getUser_id())
		{	
			System.out.println("qid"+qId);
			org.hibernate.Query q=ses.createQuery("delete from Staff where user_id= :qId");
		q.setParameter("qId", qId);
		System.out.println("q"+qId);
		System.out.println("q"+q);
		int result = q.executeUpdate();
		if(result!=0)
		{System.out.println("YeS Removed");
		li.remove(query);v=true;
		tx.commit();}
		}
			}}catch (Exception e) {
				System.out.println("Deleted");
			}
	
		return v;}
}

