package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Order;

public class OrderDaoImpl implements OrderDao
{
	Connection con = DBUtility.getConnection();
	PreparedStatement  ps;
	ResultSet rs;
    int row;
    Order order = new Order();
    double totalBill;
    
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String orderDate = formatter.format(date);
    
    
    CartDaoImpl impl = new CartDaoImpl();
    
    //Date date = new Date();
    //String orderDate =  date.toString();
    
    String place = "insert into order_22057(customer_email_id,total_bill,order_date) values(?,?,?)";
    
	String showOrderCust ="select * from order_22057 where customer_email_id = ?";
    
    String showAllOrder = "select * from order_22057 ";
    
	@Override
	public Order placeOrder(String customerEmailId)
	{
		try
		{
			ps = con.prepareStatement("select sum(c.medicine_qty*m.medicine_price) as TotalBill from medicine_22057 m inner join cart_22057 c on m.medicine_id = c.medicine_id where customer_email_id=?");
			ps.setString(1,customerEmailId);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				totalBill = rs.getDouble(1);//rs.getDouble("ToatalBill");
				ps = con.prepareStatement(place);
				ps.setString(1,customerEmailId);
				ps.setDouble(2,totalBill);
				ps.setString(3,orderDate);
				
				row = ps.executeUpdate();
				
				impl.clearCart(customerEmailId);
			}
			if(row>0) 
			{

			    ps = con.prepareStatement("select * from order_22057 where customer_email_id = ? and order_date= ?");
			    ps.setString(1, customerEmailId);
			    ps.setString(2,orderDate);
			    
				rs = ps.executeQuery();	
				
				if(rs.next()) 
				{
					order.setOrderId(rs.getInt("order_id"));
					order.setCustomerEmailId(rs.getString("customer_email_id"));
					order.setOrderStatus(rs.getString("order_status"));
					order.setTotalBill(rs.getDouble("total_bill"));
					order.setOrderDate(rs.getString("order_date"));
				}
			}
		}
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		return order;
	}
 
	@Override
	public Order placeOrder(String customerEmailId, double totalBill) {
		
		return null;
	}

	@Override
	public List<Order> showAllOrder(String customerEmailId) 
	{
		List<Order> lstOrder = new ArrayList<>();
		try 
		{
		  ps = con.prepareStatement(showOrderCust);
		  ps.setString(1, customerEmailId);
		  
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next()) 
		  {
			  order = new Order(rs.getInt("order_id"),
					  rs.getString("customer_email_id"),
					  rs.getString("order_status"),
					  rs.getDouble("total_bill"),
					  rs.getString("order_date"));
			  
		  }
		  lstOrder.add(order);
		}
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return lstOrder;
	}

	@Override
	public boolean cancelOrder(int orderId)
	{
		try 
		{
			ps = con.prepareStatement("update order_22057 set order_status =? where order_id=?");
			ps.setString(1, "Cancelled");
			ps.setInt(2, orderId);
			
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
	public List<Order> showAllOrder()
	{
		List<Order> lstOrder = new ArrayList<>();
		try 
		{
		  PreparedStatement ps = con.prepareStatement(showAllOrder);
	  
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next()) 
		  {
			  //Sequence of columns match with mySql
			  order = new Order(
					  rs.getInt(1),//Column index starting with 1 
					  rs.getString(2),
					  rs.getString(3),
					  rs.getDouble(4),
					  rs.getString(5)
					  );
			  /*
			  order = new Order(rs.getInt("order_id"),
					  rs.getString("customer_email_id"),
					  rs.getString("order_status"),
					  rs.getDouble("total_bill"),
					  rs.getString("order_date"));
			   */
			  lstOrder.add(order);
		  }
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return lstOrder;
	}
}
