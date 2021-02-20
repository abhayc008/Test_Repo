package com.geeta.foodplaza.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.CartDao;
import com.geeta.foodplaza.dao.FoodDao;
import com.geeta.foodplaza.pojo.Cart;
import com.geeta.foodplaza.pojo.Food;

@Controller
public class CartController 
{
	Cart cart ;
	
	@Autowired
	CartDao cartDao;
	
	//food details of cart
	@Autowired
	FoodDao foodDao;
	
	@RequestMapping(value="/addtocart", method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam int foodId, HttpSession session)
	{

		ModelAndView mv = new ModelAndView();
		String cartCustEmailId = (String)session.getAttribute("customer");
		
		List<Cart> foodsIncart =cartDao.showCart(cartCustEmailId);
		
		Optional<Cart> existCart = foodsIncart.stream().filter(o -> o.getFoodId() == foodId).findFirst();
		
		if(existCart.isPresent())
		{	
			boolean flag = cartDao.updateCartQty(existCart.get().getCartId(), existCart.get().getCartFoodQuantity()+1);
			if(flag)
			{
			  mv.addObject("msg","Food added into cart successfully, food id is" +foodId);
			}
			else
			{
				mv.addObject("emsg","Food not added into cart successfully");
			}
			mv.setViewName("index");
		}
		else
		{
			if(cartCustEmailId != null)
			{
				cart = new Cart();
				cart.setFoodId(foodId);
				cart.setCartFoodQuantity(1);
				cart.setCartCustEmailId(cartCustEmailId);
				
				
				//set food details also
				Food food = foodDao.getById(foodId);
				cart.setFoodName(food.getFoodName());
				cart.setFoodPrice(food.getFoodPrice());
				
				boolean flag = cartDao.addtocart(cart);
				
				if(flag)
				{
				  mv.addObject("msg","Food added into cart successfully, food id is" +foodId);
				}
				else
				{
					mv.addObject("emsg","Food not added into cart successfully");
				}
				mv.setViewName("index");
			}
			else
			{
				mv.addObject("emsg", "Please do login before add to cart");
				mv.setViewName("login");
			}
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/showmycart", method=RequestMethod.GET)
	public ModelAndView showmycart(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		String cartCustEmailId = (String)session.getAttribute("customer");
		
		if(cartCustEmailId != null)
		{
			List<Cart> cartlist = cartDao.showCart(cartCustEmailId);
			session.setAttribute("cartlist",cartlist);
			mv.setViewName("cartlist");
			return mv;
		}
		mv.setViewName("index");
		
		return mv;
		
	}
	@RequestMapping(value="/showallcart", method=RequestMethod.GET)
	public ModelAndView showAllCart(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		String adminEmailId = (String)session.getAttribute("admin");
		
		if(adminEmailId != null)
		{
			List<Cart> cartlist = cartDao.showAllCart();
			session.setAttribute("cartlist",cartlist);
			mv.setViewName("cartlist");
			return mv;
		}
		mv.setViewName("index");
		
		return mv;
		
	}
	@RequestMapping(value="/deletecart", method=RequestMethod.GET)
	public ModelAndView deletemycart(@RequestParam("cartId") int cartId,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		String cartCustEmailId = (String)session.getAttribute("customer");
		
		if(cartCustEmailId != null)
		{
			boolean flag = cartDao.deleteFromCart(cartId);
			List<Cart> cartlist = cartDao.showCart(cartCustEmailId);
			session.setAttribute("cartlist",cartlist);
			mv.setViewName("cartlist");
			return mv;
		}
		mv.setViewName("index");
		
		return mv;
		
	}
	
	//Controller method always return the name of view or return modelandview
	//@ResponseBody -- it is used any type data by handler method instead of viewname
	@RequestMapping(value="/updateCartQty", method=RequestMethod.POST)
	@ResponseBody
	public String updateCart(@RequestParam("cartId") int cartId, @RequestParam("cartQty") int cartQty)
	{
		boolean flag = cartDao.updateCartQty(cartId,cartQty);
		if(flag)
		{
			return "cart quantity is updated successfully....";
		}
		else
		{
			return "cart quantity not updated ";
		}
	}

}
