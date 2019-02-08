package com.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Department")
public class Department {

	@Id
	@TableGenerator(name="Depu",initialValue=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Depu")
	private int dept_id;
	private String dept_name;
	private int value;
	
	@OneToMany(mappedBy="dept")
	private Collection<Staff> staff= new ArrayList<>();
			
	public Department(int dept_id, String dept_name, int value) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.value = value;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", value=" + value + "]";
	} 
	
	
	
	
}
