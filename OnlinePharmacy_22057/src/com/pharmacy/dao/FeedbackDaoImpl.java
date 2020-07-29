package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Feedback;

public class FeedbackDaoImpl implements FeedbackDao
{
    Connection con = DBUtility.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    boolean flag;
    int row;
    Feedback feedback;
    

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String feedbackDate = formatter.format(date);

    
    
    String addFeed = "insert into feedback_22057(rate_us,customer_email_id,"
			+ "customer_name,suggestion, feedback_date)  values(?,?,?,?,?) ";
    
    String showFeed = "Select * from feedback_22057";
   	 
	@Override
	public boolean addFeedback(Feedback feedback)
	{
		try 
		{
			ps = con.prepareStatement(addFeed);
			ps.setInt(1, feedback.getRateUs());
			ps.setString(2, feedback.getCustomerEmailId());
			ps.setString(3, feedback.getCustomerName());
			ps.setString(4, feedback.getSuggestion());
			ps.setString(5, feedbackDate);
			
			row = ps.executeUpdate();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		if(row>0) 
		{
			return true;	
		}
		else 
		{
			return false;
		}
		
	}

	@Override
	public List<Feedback> showAllFeedback()
	{
		List<Feedback> lstFeed = new ArrayList<Feedback>();
		try 
		{
			ps = con.prepareStatement(showFeed);
			
			rs = ps.executeQuery();
		
			while(rs.next())
			{
		        feedback = new Feedback(		        	
		                rs.getInt("rate_us"),
		        		rs.getString("customer_email_id"),
		        		rs.getString("customer_name"),
		        		rs.getString("suggestion")
		        		);
		        feedback.setFeedbackId(rs.getInt("feedback_id"));
		        feedback.setFeedbackDate(rs.getString("feedback_date"));
		        
		        lstFeed.add(feedback);
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return lstFeed;
	}

}
