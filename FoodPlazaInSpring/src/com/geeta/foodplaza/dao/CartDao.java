package com.geeta.foodplaza.dao;

import java.util.List;

import com.geeta.foodplaza.pojo.Cart;

public interface CartDao 
{
	//customer cart
	boolean addtocart(Cart cart);
	
	boolean deleteFromCart(int cartId);
	List<Cart> showCart(String custEmailId);
	boolean clearCart(String customerEmailId);
	
	//admin 
	List<Cart> showAllCart();

	boolean updateCartQty(int cartId, int cartQty);

	List<Cart> isFoodInCart(int foodId, String cartCustEmailId);
}
