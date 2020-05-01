package assignment_15;

import java.io.Serializable;

class Employee1 implements Serializable
{
	private int eid;
	private String ename ;
	private String password;//for question 1st serialize all data
	//private transient String password; for  question 2nd not to serialize password
	private double salary;
    
	public Employee1(int eid, String ename, String password, double salary) {
		this.eid = eid;
		this.ename = ename;
		this.password = password;
		this.salary = salary;
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee1 [eid=" + eid + ", ename=" + ename + ", password=" + password + ", salary=" + salary + "]";
	}
	
}

