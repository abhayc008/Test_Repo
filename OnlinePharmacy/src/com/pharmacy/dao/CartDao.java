package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Cart;

public interface CartDao
{
	boolean addToCart(Cart cart);
	boolean deleteToCart(int cartId);//delete single item where cartId=?
	boolean updateMedicineQuantity(int cartId, int medicineQuantity);
	Cart isMedicineInCart(int medicineId, String CustomerEmailId);
	boolean clearCart(String customerEmailId);//clear whole cart where customerEmailID =?
	List<Cart> showCart(String CustomerEmailId);
}
