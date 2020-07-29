package com.pharmacy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.pharmacy.dao.MedicineDaoImpl;
import com.pharmacy.pojo.Medicine;


@MultipartConfig
@WebServlet("/MedicineServlet")

public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    Medicine medicine;
    MedicineDaoImpl impl = new MedicineDaoImpl();
    List<Medicine> medicineList = new ArrayList<>();
    boolean flag;

    public MedicineServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String key=request.getParameter("action");
		String operation = request.getParameter("name");
		
		if(operation != null && operation.equals("checkmedicinename")) 
		{
			medicineList = impl.showAllMedicine();			
			
			if(!medicineList.isEmpty()) 
			{
			    
			    Gson gson = new Gson();
			    
			    String message = gson.toJson(medicineList);// converting java object to json
			    
			    response.setContentType("application/json"); //type by default text/java
			    
			    out.print(message);
			}
			
		}
		
	    else if(key!=null && key.equals("delete")) 
		{
				int medicineId = Integer.parseInt(request.getParameter("medId"));
				flag = impl.deleteMedicine(medicineId);
				
				if(flag) 
				{
					medicineList = impl.showAllMedicine();
					session.setAttribute("medList", medicineList);				
					request.setAttribute("status", "been deleted");
					
					//response.sendRedirect("MedicineList.jsp");
				}
				else 
				{
					request.setAttribute("status", "not been deleted");
				}
				
				RequestDispatcher rd= request.getRequestDispatcher("MedicineList.jsp");
				rd.forward(request, response);
				
		}
		else if(key!=null && key.equals("update"))
		{
			int medicineId = Integer.parseInt(request.getParameter("medId"));
			medicine = impl.searchMedicineById(medicineId);
			
			session.setAttribute("med", medicine);
			response.sendRedirect("UpdateMedicine.jsp");
			
		}
		else if(key!=null && key.equals("search"))
		{
			String medicineName = request.getParameter("medname");
			medicineList =  impl.searchMedicineByMedicineName(medicineName);

			session.setAttribute("medList", medicineList);
			response.sendRedirect("MedicineList.jsp");
			
		}
		else if(key!=null && key.equals("details"))
		{
			int medicineId = Integer.parseInt(request.getParameter("medId"));
			medicine = impl.searchMedicineById(medicineId);
			
			session.setAttribute("med", medicine);
			response.sendRedirect("MedicineDetails.jsp");
			
		}
		else 
		{
            medicineList = impl.showAllMedicine();
			session.setAttribute("medList", medicineList);
			response.sendRedirect("MedicineList.jsp");
		}		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String medicineName,medicineType,medicineBrand,medicineDiscription,mfgDate,expiryDate;
		int medicineQty, medicineId;
		double medicinePrice;
		InputStream medicineImage;
		
		Part part = null;
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String key=request.getParameter("action");
		
		if(key!=null && key.equals("add")) 
		{ 
			medicineName=request.getParameter("medname");
			medicineType=request.getParameter("medtype");
			medicineBrand=request.getParameter("medbrand");
			medicineDiscription=request.getParameter("meddiscription");
			medicineQty=Integer.parseInt(request.getParameter("medqty"));
			mfgDate=request.getParameter("medmfgdate");
			expiryDate=request.getParameter("medexpdate");
			medicinePrice=Double.parseDouble(request.getParameter("medprice"));
			
			part = request.getPart("medimage");
			medicineImage = part.getInputStream();

			
			medicine = new Medicine(medicineName,medicineType,medicineBrand,medicineDiscription,medicineQty,mfgDate,expiryDate,medicinePrice);
            
			medicine.setMedicineImage(medicineImage);
			flag= impl.addMedicine(medicine);
	        
			if(flag) 
			{
				medicineList = impl.showAllMedicine();
				session.setAttribute("medList", medicineList);
				request.setAttribute("status", "been added");
				//response.sendRedirect("MedicineList.jsp");
			}
			else 
			{
				request.setAttribute("status", "not been added");
			}
			RequestDispatcher rd= request.getRequestDispatcher("MedicineList.jsp");
			rd.forward(request, response);	
		}
		if(key!=null && key.equals("update")) 
		{
			medicineId=Integer.parseInt(request.getParameter("medid"));
			medicineName=request.getParameter("medname");
			medicineType=request.getParameter("medtype");
			medicineBrand=request.getParameter("medbrand");
			medicineDiscription=request.getParameter("meddiscription");
			medicineQty=Integer.parseInt(request.getParameter("medqty"));
			mfgDate=request.getParameter("medmfgdate");
			expiryDate=request.getParameter("medexpdate");
			medicinePrice=Double.parseDouble(request.getParameter("medprice"));
			
			part = request.getPart("medimage");
			
			if(part.getSize() != 0) 
			{
				medicineImage = part.getInputStream();
			}
			else 
			{
				medicine = impl.searchMedicineById(medicineId);
				medicineImage = medicine.getMedicineImage();
			}
			
			medicine = new Medicine(medicineName,medicineType,medicineBrand,medicineDiscription,medicineQty,mfgDate,expiryDate,medicinePrice);
		
            medicine.setMedicineId(medicineId);
            medicine.setMedicineImage(medicineImage);
            
			flag= impl.updateMedicine(medicine);	
			
			if(flag) 
			{
				medicineList = impl.showAllMedicine();
				session.setAttribute("medList", medicineList);
				request.setAttribute("status", "been updated");

				//response.sendRedirect("MedicineList.jsp");
			}
			else 
			{
				request.setAttribute("status", "not been updated");

			}
			
			RequestDispatcher rd= request.getRequestDispatcher("MedicineList.jsp");
			rd.forward(request, response);
			
		}
		
	}
}