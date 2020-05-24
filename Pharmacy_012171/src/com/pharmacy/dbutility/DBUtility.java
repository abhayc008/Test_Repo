package com.pharmacy.dbutility;
import java.sql.*;

public class DBUtility 
{
   public static Connection getConnection() 
   {
	Connection con = null;
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");// it is load a class
		con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy_012171","root","geet");
	}
	catch(ClassNotFoundException | SQLException e ) 
	{
		e.printStackTrace();
	}
	return con;   
   }
}
