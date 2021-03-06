package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Cart;

public class CartDaoImpl implements CartDao 
{
    

    Cart cart;
	Connection con = DBUtility.getConnection();
	int row;
	
	String addCt = "insert into cart_012171(medicine_id,"
			+ "medicine_qty,customer_email_id) values(?,?,?)";
	
	String deleteCt="delete from cart_012171 where cart_id = ?";
			
	String clearCt = "delete from cart_012171 where customer_email_id = ?";
	

	String  showCt = "select c.cart_id,c.medicine_id, m.medicine_name, c.customer_email_id, c.medicine_qty, m.medicine_price"
			+ " from medicine_012171 m inner join cart_012171 c on c.medicine_id =m.medicine_id where c.customer_email_id=?";
    
	@Override
	public boolean addToCart(Cart cart)
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement(addCt);
			ps.setInt(1, cart.getMedicineId());
			ps.setInt(2,cart.getMedicineQty());
			ps.setString(3, cart.getCustomerEmailId());
			
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
	public boolean deleteToCart(int cartId)//delete single item where cartId=?
	{
		try 
		{
		    PreparedStatement ps = con.prepareStatement(deleteCt);
		    ps.setInt(1, cartId);
	        
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
	public boolean clearCart(String customerEmailId) //clear cart for  after proceed the oreder placed
	{
		try 
		{
		    PreparedStatement ps = con.prepareStatement(clearCt);
		    ps.setString(1, customerEmailId);
		    
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
	public List<Cart> showCart(String customerEmailId)
	{
		List<Cart> lstCart = new ArrayList<>();
		try 
		{
			
			PreparedStatement ps = con.prepareStatement(showCt);
			ps.setString(1,customerEmailId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				 
				 cart = new Cart(rs.getInt("medicine_id"),
						 rs.getString("medicine_name"),
						 rs.getInt("medicine_qty"),
						 rs.getDouble("medicine_price"),
						 rs.getString("customer_email_id"));
				 cart.setCartId(rs.getInt("cart_id"));
				 
				 lstCart.add(cart);
			}
			
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return lstCart;
	}
}
