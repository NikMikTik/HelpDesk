package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.ForeignKey;

import connection.util.HibernateUtil;

@Entity
@Table(name="Query")
public class Query {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Query_id;
	@ForeignKey(name="user_id")
	private int user_id;
	private String query;
	@ForeignKey(name="dept_id")
	private int dept_id;
	private String status;
	private String response;
	private String issue;
	private int staff_id;
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public int getQuery_id() {
		return Query_id;
	}
	public void setQuery_id(int query_id) {
		Query_id = query_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public Query() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Query(int query_id, int user_id, String query, int dept_id, String status, String response, String issue,
			int staff_id) {
		super();
		Query_id = query_id;
		this.user_id = user_id;
		this.query = query;
		this.dept_id = dept_id;
		this.status = status;
		this.response = response;
		this.issue = issue;
		this.staff_id = staff_id;
	}
	@Override
	public String toString() {
		return "Query [Query_id=" + Query_id + ", user_id=" + user_id + ", query=" + query + ", dept_id=" + dept_id
				+ ", status=" + status + ", response=" + response + ", issue=" + issue + ", staff_id=" + staff_id + "]";
	}
	public boolean enterQ(String name,int cId,String iss)
	{boolean v=false;
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	Query qq=new Query();
	qq.setQuery(name);
	qq.setUser_id(cId);
	qq.setResponse("Query under Process");
	qq.setStatus("Staff Not Allocated");
	qq.setIssue(iss);
	ses.save(qq);
	tx.commit();
	ses.close();
	v=true;
		return v;}
	
	
	public List<Query> getQ(int cId)
	{System.out.println("ccccc"+cId);
		List<Query> q=new ArrayList<>();
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Query");
	List<Query> li=qqq.list();
	for (Query query : li) {
		if(cId==query.getUser_id())
		{q.add(query);}
			}
	
		return q;}
	

	public List<Query> getSSQ(int cId)
	{System.out.println("gjgcc"+cId);
		List<Query> q=new ArrayList<>();
	Session ses=HibernateUtil.getSessionFactory().openSession();System.out.println("afterer ses");
	Transaction tx=ses.beginTransaction();System.out.println("going in");
	org.hibernate.Query qqq=ses.createQuery("from Query");
	List<Query> li=qqq.list();
	for (Query query : li) {System.out.println("in for+");
		if(cId==query.getStaff_id())
		{q.add(query);System.out.println("in ifffff"+q+"\n");}
			}
	
		return q;}
	
	
	public boolean delQ(int qId)
	{boolean v=false;
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Query");
	List<Query> li=qqq.list();
	try{for (Query query : li) {
		if(qId==query.getQuery_id())
		{	
			System.out.println("qid"+qId);
			org.hibernate.Query q=ses.createQuery("delete from Query where Query_id= :qId");
		q.setParameter("qId", qId);
		System.out.println("q"+qId);
		System.out.println("q"+q);
		int result = q.executeUpdate();
		if(result!=0)
		{System.out.println("YeS Removed");
		li.remove(query);v=true;
		tx.commit();
		}
		}
	}}catch (Exception e) {
		System.out.println("Deleted");
	}
	
		return v;}
	
	public String knowledge(String queryn)
	{int v=1;String rr = "",ss="Query Resolved";System.out.println("quququuquq"+queryn);
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Query where query like :qn AND status= :ss");
	qqq.setString("qn", queryn);
	qqq.setString("ss", ss);
	List<Query> qtt=qqq.list();
	for (Query Q : qtt) {
		System.out.println("yuyuy8u"+Q);
		rr=Q.getResponse();
	}
	if(qtt.isEmpty())
	{rr="_"+"0";System.out.println("is Emptyyyyyyy");}
	else
		rr=rr+"_"+"2";
	System.out.println("thiisisi"+rr);
	return rr;
		}
	
	public List<Query> getknowledge()
	{List<Query> q=new ArrayList<>();String rr = "",rrt="",ss="Query Resolved";
	Session ses=HibernateUtil.getSessionFactory().openSession();
	System.out.println("afterer ses");
	Transaction tx=ses.beginTransaction();
	System.out.println("going in");
	org.hibernate.Query qqq=ses.createQuery("from Query where status= :ss");
	qqq.setString("ss", ss);
	List<Query> li=qqq.list();
	System.out.println("loloadxjsdehwuadfuys"+li);
	
	return li;}
	
	public boolean delAQ(int qId)
	{boolean v=false;
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Query");
	List<Query> li=qqq.list();
	try{
	for (Query query : li) {
		if(qId==query.getQuery_id())
		{	
			
			org.hibernate.Query q=ses.createQuery("delete from Query where Query_id= :qId");
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
	
	
	
	public List<Query> getAllQ(){
		List<Query> q1=new ArrayList<>();
		Session ses=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		org.hibernate.Query q=ses.createQuery("from Query");
		List<Query> li=q.list();
		for (Query query : li) {
			q1.add(query);
		}
		
		return q1;
		
	}
	
public boolean giveResponse(String res,int Qid)
{boolean v=false;String sss="Query Resolved";
System.out.println("in give R");
Session ses=HibernateUtil.getSessionFactory().openSession();
Transaction tx=ses.beginTransaction();
org.hibernate.Query qi=ses.createQuery("update Query set response= :res,status= :sss where query_id= :qId");
qi.setParameter("res", res);
qi.setParameter("qId", Qid);
qi.setParameter("sss", sss);
int rowC=qi.executeUpdate();
tx.commit();System.out.println("ytytytytyty"+res);
if(rowC!=0)
	{v=true;
	}
return v;}
	
public int allocateStaff(int qId){
		System.out.println("allocate Stassss1");
		
		Session ses=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();int d=0;String iss;
		org.hibernate.Query q=ses.createQuery("from Query");
		List<Query> li=q.list();
		
		
		for (Query query : li) {
			if(qId==query.getQuery_id())
			{
				if(query.getIssue().equals("HR"))
				{d=1;iss="HR";
					org.hibernate.Query qq=ses.createQuery("update Query set dept_id= :d where issue= :iss and query_id= :qId");
					qq.setParameter("d", d);
					qq.setParameter("qId", qId);
					qq.setParameter("iss", iss);
					int rowC=qq.executeUpdate();
					System.out.println("Rows affected"+rowC);
					tx.commit();
				}
				
				else if(query.getIssue().equals("TECH")){
					d=2;iss="TECH";
					org.hibernate.Query qq=ses.createQuery("update Query set dept_id= :d where issue= :iss and query_id= :qId");
					qq.setParameter("d", d);
					qq.setParameter("qId", qId);
					qq.setParameter("iss", iss);
					int rowC=qq.executeUpdate();
					System.out.println("Rows affected"+rowC);
					tx.commit();
				}else if(query.getIssue().equals("SUPPORT")){
					d=3;iss="SUPPORT";
					org.hibernate.Query qq=ses.createQuery("update Query set dept_id= :d where issue= :iss and query_id= :qId");
					qq.setParameter("d", d);
					qq.setParameter("qId", qId);
					qq.setParameter("iss", iss);
					int rowC=qq.executeUpdate();
					System.out.println("Rows affected"+rowC);
					tx.commit();
				}
				
			}}
		return d;
			
				
	}


public List<Staff> aas(int qId,int k)
{
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();int d=0;String iss;System.out.println("after update");List<Staff> u=new ArrayList<>();
org.hibernate.Query qui=ses.createQuery("from Query");
List<Query> lii=qui.list();
for (Query qit : lii) {
	if(qId==qit.getQuery_id())
	{
		System.out.println("after in sec query"+qit.getQuery_id()+"puchi"+k);
	if(k==1)
	{
		System.out.println("after update in ghghgh");
		org.hibernate.Query qimm=ses.createQuery("from User where dept_id=1");
		u=qimm.list();System.out.println("allocate Stassss dddddddd HRR");					
	}
		
	else if(k==2){
		org.hibernate.Query qimm=ses.createQuery("from User where dept_id=2");
		 u=qimm.list();					
	}
	else if(k==3){
		org.hibernate.Query qimm=ses.createQuery("from User where dept_id=3");
		u=qimm.list();	}
	}
					
}
return u;}

public boolean alloS(int qId,int sId)
{boolean v=false;String sss="Staff Allocated";
System.out.println("sId is"+sId+"kuchikoo"+qId);

Session ses=HibernateUtil.getSessionFactory().openSession();
Transaction tx=ses.beginTransaction();
org.hibernate.Query qqq=ses.createQuery("from Query");
List<Query> li=qqq.list();System.out.println("vvoovovo");

for (Query query : li) {
	if(qId==query.getQuery_id())
	{System.out.println("vvoovovohhhhhhhhooo"+query.getQuery_id());
	org.hibernate.Query q=ses.createQuery("update Query set staff_id= :sId, status= :sss where query_id= :qId");
	q.setParameter("sId", sId); 
	q.setParameter("qId", qId);
	q.setParameter("sss", sss);
	int rowC=q.executeUpdate();
	System.out.println("Rows affected"+rowC);
	System.out.println("got it");
	
	tx.commit();
	v=true;}
	
}

	return v;}
	
	public List<Query> getSQ(int sId)
	{List<Query> q=new ArrayList<>();
System.out.println("sId is"+sId);
	Session ses=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=ses.beginTransaction();
	org.hibernate.Query qqq=ses.createQuery("from Query");
	List<Query> li=qqq.list();
	for (Query query : li) {
		System.out.println("in forr");
		if((sId==query.getStaff_id())&& (query.getResponse().equals("Query under Process")))
		{q.add(query);
		System.out.println("\nwe are here"+q);}
			}
	System.out.println("\nwe are here aftererrrrrrrrr"+q);
		return q;}
}
