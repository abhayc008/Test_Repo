package com.pharmacy.pojo;

public class Medicine
{     
	
	private int medicineId, medicineQty;
	   private String medicineName, medicineType, medicineBrand, medicineDiscription;
	   private String mfgDate, expiryDate;
	   private double medicinePrice;
	   
	   public Medicine(String medicineName, String medicineType, String medicineBrand,
			String medicineDiscription,int medicineQty,  String mfgDate, String expiryDate, double medicinePrice) {
		super();
		this.medicineName = medicineName;
		this.medicineType = medicineType;
		this.medicineBrand = medicineBrand;
		this.medicineDiscription = medicineDiscription;
		this.medicineQty = medicineQty;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.medicinePrice = medicinePrice;
	}
	   
    public Medicine() {
		// TODO Auto-generated constructor stub
	}

	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public int getMedicineQty() {
		return medicineQty;
	}
	public void setMedicineQty(int medicineQty) {
		this.medicineQty = medicineQty;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineType() {
		return medicineType;
	}
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}
	public String getMedicineBrand() {
		return medicineBrand;
	}
	public void setMedicineBrand(String medicineBrand) {
		this.medicineBrand = medicineBrand;
	}
	public String getMedicineDiscription() {
		return medicineDiscription;
	}
	public void setMedicineDiscription(String medicineDiscription) {
		this.medicineDiscription = medicineDiscription;
	}
	public String getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
   
	   @Override
		public String toString() {
			return "Medicine [medicineId=" + medicineId + ", medicineQty=" + medicineQty + ", medicineName=" + medicineName
					+ ", medicineType=" + medicineType + ", medicineBrand=" + medicineBrand + ", medicineDiscription="
					+ medicineDiscription + ", mfgDate=" + mfgDate + ", expiryDate=" + expiryDate + ", medicinePrice="
					+ medicinePrice + "]";
		}
	   
   
   
}