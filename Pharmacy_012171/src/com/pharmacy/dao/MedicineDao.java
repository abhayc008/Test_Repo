package com.pharmacy.dao;
import java.util.List;
import com.pharmacy.pojo.Medicine;

public interface MedicineDao
{
	boolean addMedicine(Medicine medicine);
    boolean updateMedicine(Medicine medicine);
    boolean   deleteMedicine(int medicineId);
    Medicine searchMedicineById(int medicineId);
    List<Medicine> searchMedicineByMedicineName(String medicineName);
    List<Medicine> searchMedicineByMedicineBrand(String medicineBrand);
    List<Medicine> showAllMedicine();
}
