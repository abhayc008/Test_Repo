package com.geeta.foodplaza.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.geeta.foodplaza.dao.CartDao;
import com.geeta.foodplaza.pojo.Cart;

public class CartDaoImpl implements CartDao 
{
	
	HibernateTemplate hibernateTemplate;

	public CartDaoImpl(org.springframework.orm.hibernate5.HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public boolean addtocart(Cart cart)
	{
	    int i = (int)hibernateTemplate.save(cart);
	    
	    if(i>0)
	    {
	    	return true;
	    }
		return false;
	}

	@Override
	public List<Cart> showCart(String custEmailId)
	{
		String sqlQuery = "From Cart where cartCustEmailId ='"+custEmailId+"'";
		
		List<Cart> cartlist = (List<Cart>) hibernateTemplate.find(sqlQuery);
		return cartlist;
	}


	@Override
	@Transactional
	public boolean deleteFromCart(int cartId) 
	{	
		Cart cart = hibernateTemplate.get(Cart.class, cartId);
		
		if(cart!=null)
		{
			hibernateTemplate.delete(cart);
			return true;
		}
		return false;
	}

	@Override
	public List<Cart> showAllCart() {
		return hibernateTemplate.loadAll(Cart.class);
	}

	@Override
	@Transactional
	public boolean updateCartQty(int cartId, int cartQty) 
	{
		Cart cart = hibernateTemplate.get(Cart.class, cartId);
		cart.setCartFoodQuantity(cartQty);
		
		hibernateTemplate.update(cart);
		return true;
	}

	@Override
	@Transactional
	public boolean clearCart(String customerEmailId)
	{
		List<Cart>  cartlist   = (List<Cart>)hibernateTemplate.find("from Cart where cartCustEmailId =?0 ",new Object[]{customerEmailId} );
		
		if(!cartlist.isEmpty())
		{
		  hibernateTemplate.deleteAll(cartlist);
		  return true;
		}
		return false;
	}

	@Override
	public List<Cart> isFoodInCart(int foodId, String cartCustEmailId) 
	{
		List<Cart> lstCart = (List<Cart>)hibernateTemplate.find("from Cart where cartCustEmailId =?0 and foodId=?1",new Object[]{cartCustEmailId,foodId});
		
		return lstCart;
		
	}

}
