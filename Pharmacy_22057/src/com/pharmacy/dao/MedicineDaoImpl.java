package com.pharmacy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbutility.DBUtility;
import com.pharmacy.pojo.Medicine;

public class MedicineDaoImpl implements MedicineDao 
{
	
    Medicine medicine;
	Connection con = DBUtility.getConnection();
	int row;
	
	
    String addMed = "insert into medicine_22057(medicine_name,medicine_type,medicine_brand,"
    		+ "medicine_discription,medicine_qty,mfg_date,expiry_date,medicine_price) values(?,?,?,?,?,?,?,?)";

	String updateMed = "update  medicine_22057 set  medicine_name=?,medicine_type=?,medicine_brand=?,  medicine_discription=?,"
			+ "medicine_qty=?,mfg_date=?,expiry_date=?,medicine_price=? where medicine_id=? ";
	
	String deleteMed = "delete from medicine_22057 where medicine_id = ?";
	
	String searchById = "Select * from medicine_22057 where medicine_id= ?";
	
	String searchByName = "Select * from medicine_22057 where medicine_name like ?";
	
	String searchByBrand = "Select * from medicine_22057 where medicine_brand = ?";
	
	String showAll = "Select * from medicine_22057";
	
	@Override
	public boolean addMedicine(Medicine medicine)
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement(addMed);
			ps.setString(1, medicine.getMedicineName());
			ps.setString(2, medicine.getMedicineType());
			ps.setString(3, medicine.getMedicineBrand());
			ps.setString(4, medicine.getMedicineDiscription());
			ps.setInt(5, medicine.getMedicineQty());
			ps.setString(6, medicine.getMfgDate());
			ps.setString(7, medicine.getExpiryDate());
			ps.setDouble(8, medicine.getMedicinePrice());
			
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
	public boolean updateMedicine(Medicine medicine) {
		
		try 
		{ 
				PreparedStatement ps = con.prepareStatement(updateMed);
				ps.setString(1, medicine.getMedicineName());
				ps.setString(2, medicine.getMedicineType());
				ps.setString(3, medicine.getMedicineBrand());
				ps.setString(4, medicine.getMedicineDiscription());
				ps.setInt(5, medicine.getMedicineQty());
				ps.setString(6, medicine.getMfgDate());
				ps.setString(7, medicine.getExpiryDate());
				ps.setDouble(8, medicine.getMedicinePrice());
				ps.setInt(9, medicine.getMedicineId());
				
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
	public boolean deleteMedicine(int medicineId) 
	{
		try 
		{
		   PreparedStatement ps = con.prepareStatement(deleteMed);
		   ps.setInt(1, medicineId);
		   
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
	/*
	public Medicine searchMedicineById(int medicineId)
	{
		try 
		{
		 	  PreparedStatement ps = con.prepareStatement(searchById);
	    	  ps.setInt(1, medicineId);
	    	  
	    	  ResultSet rs = ps.executeQuery();
	    	  if(rs.next()) 
	    	  {
	    		  medicine = new Medicine(
	    				  rs.getString("medicine_name"),
	    				  rs.getString("medicine_type"),
	    				  rs.getString("medicine_brand"),
	    				  rs.getString("medicine_discription"),
	    				  rs.getInt("medicine_qty"),
	    				  rs.getString("mfg_date"),
	    				  rs.getString("expiry_date"),
	    				  rs.getDouble("medicine_price")
	    				  );
	    		  medicine.setMedicineId(rs.getInt("medicine_id"));
	    	  }
	    	  
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
    	  return medicine;

	}*/
	
   
	@Override
	public Medicine searchMedicineById(int medicineId)
	{
		try 
	    {   
	          	    
      	  PreparedStatement ps = con.prepareStatement(searchById);
      	  ps.setInt(1, medicineId);
      	  
      	  ResultSet rs = ps.executeQuery();

      	if (!rs.isBeforeFirst() ) {    
      	    medicine = new Medicine(); 
      	} 
      	else {
      		  
      	  while (rs.next()) 
			   {
      		  			    medicineId = rs.getInt("medicine_id");
				    	   String medicinename = rs.getString("medicine_name");
				    	   String type = rs.getString("medicine_type");
						   String brand = rs.getString("medicine_brand");
						   String discription = rs.getString("medicine_discription");
						   int quantity = rs.getInt("medicine_qty");
						   String mfgdate = rs.getString("mfg_date");
						   String expiry = rs.getString("expiry_date");
						   double price  = rs.getDouble("medicine_price");
								   
						  // System.out.println(medicineId+ " "+type+ " "+brand+" "+discription+" "+quantity+ " "+mfgdate+" "+expiry+" "+price);
						  medicine = new Medicine(medicinename,type,brand,discription,quantity,mfgdate,expiry,price); 
						  medicine.setMedicineId(medicineId);
								   
			 }
      	  }
				 
	    }   
		
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
		return medicine;
	}
	
	@Override
	public List<Medicine> searchMedicineByMedicineName(String medicineName)
	{
		List<Medicine> lstMedicine = new ArrayList<>();
	    try 
	    { 
	    	  
	    	  PreparedStatement ps = con.prepareStatement(searchByName);
	          ps.setString(1, "%" + medicineName + "%");
	          
			  ResultSet rs = ps.executeQuery();
			   
			  while (rs.next()) 
			   { 
				   String name = rs.getString("medicine_name");
				   if(name.contains(medicineName)) 
				   {
					   Medicine med = new Medicine(rs.getString("medicine_name"),
							   rs.getString("medicine_type"),
							   rs.getString("medicine_brand"),
							   rs.getString("medicine_discription"),
							   rs.getInt("medicine_qty"),
							   rs.getString("mfg_date"),
							   rs.getString("expiry_date"),
							   rs.getDouble("medicine_price"));
					   
					   med.setMedicineId(rs.getInt("medicine_id"));
					   
					   lstMedicine.add(med);
				   }				
			   }	   
			  
	    }
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
	    return lstMedicine;
	}
	/*
	@Override
	public List<Medicine> searchMedicineByMedicineName(String medicineName)
	{
		List<Medicine> lstMedicine = new ArrayList<>();
	    try 
	    {
	    	  String searchByName = "Select * from medicine_22057 where medicine_name  like  '%"+medicineName+"%'";
	    	  
	    	  PreparedStatement ps = con.prepareStatement(searchByName);
	          //ps.setString(1, medicineName);
	          
			  ResultSet rs = ps.executeQuery();
			   
			  
			  while (rs != null && rs.next()) 
			   {
				   
				   String name = rs.getString("medicine_name");
				   
				   if(name.contains(medicineName)) 
				   {
					   
					   int medicineId = rs.getInt("medicine_id");  
					   String medicinename = rs.getString("medicine_name");
					   String type = rs.getString("medicine_type");
					   String brand = rs.getString("medicine_brand");
					   String discription = rs.getString("medicine_discription");
					   int quantity = rs.getInt("medicine_qty");
					   String mfgdate = rs.getString("mfg_date");
					   String expiry = rs.getString("expiry_date");
					   double price  = rs.getDouble("medicine_price");
					   
					   //System.out.println(medicineId+ " "+type+ " "+brand+" "+discription+" "+quantity+ " "+mfgdate+" "+expiry+" "+price);
					   
					   Medicine med = new Medicine(medicineId,quantity,medicinename,type,brand,discription,mfgdate,expiry,price);
					   lstMedicine.add(med);
					      
				   }	   
			   }	   
			  
	    }
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
	    return lstMedicine;
	}
	*/

	@Override
	public List<Medicine> showAllMedicine()
	{
		List<Medicine> allMedicine = new ArrayList<>();
		try 
		{
		  PreparedStatement ps = con.prepareStatement(showAll);
		  ResultSet rs = ps.executeQuery();
		  

		  while (rs != null && rs.next()) 
		   {
			   int medicineId = rs.getInt("medicine_id");  
			   String medicineName = rs.getString("medicine_name");
			   String medicineType = rs.getString("medicine_type");
			   String medicineBrand = rs.getString("medicine_brand");
			   String medicineDiscription = rs.getString("medicine_discription");
			   int medicineQty = rs.getInt("medicine_qty");
			   String mfgDate = rs.getString("mfg_date");
			   String expiryDate = rs.getString("expiry_date");
			   double medicinePrice  = rs.getDouble("medicine_price");

			   Medicine med = new Medicine(medicineName,medicineType,medicineBrand,medicineDiscription
					   ,medicineQty,mfgDate,expiryDate,medicinePrice);
			   
			   med.setMedicineId(medicineId);
			   allMedicine.add(med);
			   
		   }
		}
		catch(Exception  ex) 
		{
			ex.printStackTrace();
		}
        		
		return allMedicine;
	}

	@Override
	public List<Medicine> searchMedicineByMedicineBrand(String medicineBrand)
	{
		List<Medicine> lstMedicine = new ArrayList<>();
	    try 
	    { 	    	  
	    	  PreparedStatement ps = con.prepareStatement(searchByBrand);
	          ps.setString(1, medicineBrand);
	          
			  ResultSet rs = ps.executeQuery();
			   
			  
			  while (rs.next()) 
			   { 
					   Medicine med = new Medicine(rs.getString("medicine_name"),
							   rs.getString("medicine_type"),
							   rs.getString("medicine_brand"),
							   rs.getString("medicine_discription"),
							   rs.getInt("medicine_qty"),
							   rs.getString("mfg_date"),
							   rs.getString("expiry_date"),
							   rs.getDouble("medicine_price"));
					   
					   med.setMedicineId(rs.getInt("medicine_id"));
					   
					   lstMedicine.add(med);				
			   }	   
			  
	    }
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
	    return lstMedicine;
	} 
	
}
