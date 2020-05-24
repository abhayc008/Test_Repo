package com.pharmacy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.pojo.Medicine;

import com.pharmacy.dao.MedicineDaoImpl;


public class MedicineTest {

	public static void main(String[] args) throws IOException
	
	{
		int choice, medicineId;
		String medicineName, medicineType, medicineBrand, medicineDiscription, mfgDate, expiryDate;
		int medicineQty;
		double medicinePrice;
		boolean flag;
		
		Medicine medicine;
		List<Medicine> search;
		
     	MedicineDaoImpl impl = new MedicineDaoImpl();
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
		System.out.println("-----------Welcome to Pharmacy-----------");
		
	    try 
	    {
	    	while(true) 
			{
				System.out.println("1.Add Medicine");
				System.out.println("2. Update Medicine");
				System.out.println("3. Delete Medicine");
				System.out.println("4. Search Medicine by Id");
				System.out.println("5 Search Medicine by medicine name");
				System.out.println("6.Show all Medicine");
				System.out.println("7.Exit");
				
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				
				switch(choice) 
				{
				case 1:
					System.out.println("-------------Add Medicine---------");
					
					System.out.println("Enter Medicine Name");
					medicineName = br.readLine();
				   	
					System.out.println("Enter Type Of Medicine ");
					medicineType = br.readLine();
					
					System.out.println("Enter Medicine brand");
					medicineBrand = br.readLine();
					
					System.out.println("Enter Medicine discription");
					medicineDiscription = br.readLine();
					
					System.out.println("Enter Medicine Quantity");
					medicineQty = scanner.nextInt();
					
					System.out.println("Enter Manufacture date");
					mfgDate = br.readLine();
					
					System.out.println("Enter Expiry date");
					expiryDate = br.readLine();
					
					System.out.println("Enter Medicine price");
					medicinePrice = scanner.nextDouble();
					
					medicine = new Medicine(medicineQty, medicineName,medicineType,medicineBrand,
						 medicineDiscription,mfgDate,expiryDate,medicinePrice);
					
					
					flag = impl.addMedicine(medicine);
					
					if(flag) 
					{
						System.out.println("Successfully added !!!");
					}
					else 
					{
						System.out.println("Failed");
					}
					
					break;
				case 2:
					System.out.println("--------Update Medicine--------------");
					
					System.out.println("Enter existing Medicine Id");
				    medicineId = scanner.nextInt();
				   	
					System.out.println("Enter Type Of Medicine Name ");
					medicineName = br.readLine();
					
					System.out.println("Enter Type Of Medicine ");
					medicineType = br.readLine();
					
					System.out.println("Enter Medicine brand");
					medicineBrand = br.readLine();
					
					System.out.println("Enter Medicine discription");
					medicineDiscription = br.readLine();
					
					System.out.println("Enter Medicine Quantity");
					medicineQty = scanner.nextInt();
					
					System.out.println("Enter Manufacture date");
					mfgDate = br.readLine();
					
					System.out.println("Enter Expiry date");
					expiryDate = br.readLine();
					
					System.out.println("Enter Medicine price");
					medicinePrice = scanner.nextDouble();
					
					medicine = new Medicine(medicineQty, medicineName,medicineType,medicineBrand,
						 medicineDiscription,mfgDate,expiryDate,medicinePrice);
					
					medicine.setMedicineId(medicineId);
					
				    flag = impl.updateMedicine(medicine);
					
					if(flag) 
					{
						System.out.println("Successfully Updated !!!");
					}
					else 
					{
						System.out.println("Failed");
					}
					break;
				case 3:
					System.out.println("--------Delete Medicine--------------");
					
					System.out.println("Enter medicine Id");;
					medicineId = scanner.nextInt();

				    flag = impl.deleteMedicine(medicineId);
					
					if(flag) 
					{
						System.out.println("Deleted Successfully !!!");
					}
					else 
					{
						System.out.println("Failed");
					}
					break;
				case 4:
					System.out.println("Enter medicine id");
					medicineId = scanner.nextInt();
					medicine = impl.searchMedicineById(medicineId);
					
					if(medicine.getMedicineId()>0) 
					{
						System.out.println("medicineId   ||  medicineQty || medicineName ||"+
								 "medicineType || medicineBrand || medicineDiscription ||"+
								 "mfgDate || expiryDate || medicinePrice");
						System.out.println("  " + medicine.getMedicineId() + "  " + medicine.getMedicineQty() + "  " + medicine.getMedicineName()
								+ "  " + medicine.getMedicineType() + "  " + medicine.getMedicineBrand() + "  "
								+ medicine.getMedicineDiscription() + " " + medicine.getMfgDate() + " " + medicine.getExpiryDate()+ " "
								+ medicine.getMedicinePrice()+ " ");
				
					}
					else 
					{
						System.out.println("Medicine not found with id "+medicineId);
					}
					break;
				case 5:
					System.out.println("Enter medicine name");
					medicineName = br.readLine();
					search = impl.searchMedicineByMedicineName(medicineName);
					System.out.println(search);
					break;
				case 6:
					System.out.println("-----------Details of medicine-------------");
					search = impl.showAllMedicine();
                    
					for(Medicine a: search)
					{
						System.out.println(" "+a);
					}
					break;
				case 7:
					System.out.println("Thanking you for Visiting!!!");
					System.exit(0);
				default:
					System.out.println("Please enter valid choice");
				}
		    	
			}
	
	    }
	    catch(Exception ex) 
	    {
	    	ex.printStackTrace();
	    }
	    
		
				  
	}

 }

