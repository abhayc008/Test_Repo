package com.geeta.foodplaza.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.geeta.foodplaza.dao.LoginDao;

@Controller
public class LoginController 
{
	@Autowired
	LoginDao loginDao;
	
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public ModelAndView showLoginForm()
	{			
		 ModelAndView mv = new  ModelAndView();
		 mv.setViewName("login");
		 return mv;
		
	}
	
	@RequestMapping(value="dologin", method=RequestMethod.POST)
	public ModelAndView doLogin(@RequestParam("usertype") String usertype,
			@RequestParam("emailId") String emailId,
			@RequestParam("password") String password, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		if(usertype.equals("admin"))
		{
			boolean flag = loginDao.isAdmin(emailId, password);
			
			if(flag == true)
			{ 
				session.setAttribute("admin", emailId);
				mv.addObject("msg","Admin login successfully");
				mv.setViewName("index");
				//System.out.println("Admin Login here");
			}
			else
			{
				mv.addObject("msg","Admin login Unsuccessfully <br>Try Again");
				mv.setViewName("login");
			}
		}
		else if(usertype.equals("customer"))
		{
			boolean flag = loginDao.isCustomer(emailId, password);
			
			if(flag==true)
			{
				session.setAttribute("customer", emailId);
				mv.addObject("msg","Customer login successfully");
				mv.setViewName("index");
				//System.out.println("Customer Login here");	
			}
			else 
			{
				mv.addObject("msg","Customer login Unsuccessfully <br>Try Again");
				mv.setViewName("login");
			}
			
		}
		else
		{
			mv.addObject("msg", "Select user type...");
			mv.setViewName("login");
		}
		return mv;
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session)
	{			
		 session.invalidate();
		 /*
		 ModelAndView mv = new  ModelAndView();
		 mv.addObject("msg","Logout Successfully...");
		 mv.setViewName("index");
		 return mv;
		 */
		 //this is same as response.sendRedirect() method of httPServletResponse
		 return "redirect:home?msg=Logout+Successfully!!!";
		
	}

}
