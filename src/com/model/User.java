package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import connection.util.HibernateUtil;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "User1")
@DiscriminatorColumn(name = "User_Type", discriminatorType = DiscriminatorType.STRING)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String user_name;
	private String password;
	private int permission;

	public User(int user_id, String user_name, String password, int permission) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", permission="
				+ permission + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public User() {
		super();
	}

	public int validate(String name, String password) {
		Admin aa = new Admin();
		boolean v = false;
		int p = 0;int pmn=3;
		Session ses = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();

		Query tq = ses.createQuery("from User where permission= :pmn");
		tq.setParameter("pmn", pmn);
		List<User> u =tq.list();
		for (User user1 : u) {
			if (user1.getPermission()>2) {System.out.println("heeeeoooooooooooo");
				v = true;
			}
		}System.out.println(v);
		if (v == false)
			{aa.Enter();}
		Query q = ses.createQuery("from User");
		List<User> li = q.list();
		for (User user : li) {
			if (name.equals(user.getUser_name()) && password.equals(user.getPassword())) {
				System.out.println("WELCOME");
				p = user.getPermission();
			}

		}
		return p;

	}

	public int idgetter(String name, String password) {
		Admin aa = new Admin();
	//	aa.Enter();
		int p = 0;
		Session ses = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();

		Query q = ses.createQuery("from User");
		List<User> li = q.list();
		for (User user : li) {
			if (name.equals(user.getUser_name()) && password.equals(user.getPassword())) {
				System.out.println("WELCOME");
				p = user.getUser_id();
			}

		}
		return p;

	}

	public String getNamePwd(int cId) {
		String k = "";
		Session ses = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		Query q = ses.createQuery("from User");
		List<User> li = q.list();
		for (User user : li) {
			if (cId == user.getUser_id())
				k = user.getUser_name() + "_" + user.getPassword();
		}
		return k;
	}

}
