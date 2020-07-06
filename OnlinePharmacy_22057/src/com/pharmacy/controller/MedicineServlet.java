package com.pharmacy.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pharmacy.dao.MedicineDaoImpl;
import com.pharmacy.pojo.Medicine;



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
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String key=request.getParameter("action");
		
		if(key!=null && key.equals("delete")) 
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

			
			medicine = new Medicine(medicineName,medicineType,medicineBrand,medicineDiscription,medicineQty,mfgDate,expiryDate,medicinePrice);

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
			
			
			medicine = new Medicine(medicineName,medicineType,medicineBrand,medicineDiscription,medicineQty,mfgDate,expiryDate,medicinePrice);
		
            medicine.setMedicineId(medicineId);
            
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