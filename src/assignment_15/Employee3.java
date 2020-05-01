package assignment_15;

import java.io.Serializable;

class Employee3 implements Serializable
{
	private int eid;
	private String ename ;
	private  transient String password;
	private double salary;
	Address address;//reference of other class
	
	
	public Employee3(int eid, String ename, String password, double salary, Address address) 
	{
		this.eid = eid;
		this.ename = ename;
		this.password = password;
		this.salary = salary;
		this.address = address;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee1 [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", address=" + address + "]";
	}
	
	
}

