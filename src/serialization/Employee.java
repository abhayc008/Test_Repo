package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable
{
	

	private int eid;
	private String ename ;
	private  transient String password;
	private double salary;
	
	
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
    
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", password=" + password + ", salary=" + salary + "]";
	}

	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Employee emp = new Employee();
		emp.setEid(8);
		emp.setEname("abhay");
		emp.setSalary(10000);
		emp.setPassword("1234");
		System.out.println(emp);
		
		FileOutputStream write = new FileOutputStream("serialize1.txt");
		ObjectOutputStream writefile = new ObjectOutputStream(write);
		writefile.writeObject(emp);
		
		FileInputStream read = new FileInputStream("serialize1.txt");
		ObjectInputStream readfile = new ObjectInputStream(read);
		
		Employee empread = (Employee)readfile.readObject();
		System.out.println("Infomation of employee is......"+empread);
	}

}
