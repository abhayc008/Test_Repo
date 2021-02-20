package com.geeta.foodplaza.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.CustomerDao;
import com.geeta.foodplaza.pojo.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerDao custDao;
	
	//it should be execute by default
	
	/*
	@GetMapping(value={"/", "/home"})
	public String home(Model model)
	{
		List<Customer> flist = custDao.gets();
		model.addAttribute("customerlist", flist);
		return "index";
	}
	
	@RequestMapping("/home")
	public String index()
	{
		return "index";
	}
	*/
	@RequestMapping("/custform")
	public String showcustomerForm()
	{
		return "addcustomer";
	}
	
	@RequestMapping(value = "/savecustomer",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customer") Customer customer) 
	{
		ModelAndView mv = new ModelAndView();
		
		int id = custDao.save(customer);
		
		mv.addObject("msg", "customer is added successfully..");
		mv.addObject("customerId", id);
		mv.setViewName("addcustomer");
		return mv;
	}
	
	@RequestMapping(value = "customerlist")
	public ModelAndView list()
	{
		ModelAndView mv = new ModelAndView();
		List<Customer> customerlist = custDao.gets();
		mv.addObject("customerlist", customerlist);
		mv.setViewName("customerlist");
		return mv;
	}
	
	@RequestMapping(value = "deletecustomer")
	public ModelAndView delete(@RequestParam("customerId") int customerId)
	{
		ModelAndView mv = new ModelAndView();
		boolean flag = custDao.delete(customerId);
		
		if(flag)
			mv.addObject("msg","customer is deleted");
		else
			mv.addObject("emsg","customer is not deleted");
			
		List<Customer> customerlist = custDao.gets();
		mv.addObject("customerlist", customerlist);
		mv.setViewName("customerlist");
		return mv;
	}
	
	@RequestMapping(value = "/editcustomer")
	public ModelAndView edit(@RequestParam("customerId") int customerId)
	{
		ModelAndView mv = new ModelAndView();
		Customer customer = custDao.getById(customerId);
		mv.addObject("customer",customer);
		mv.addObject("action","update");
		mv.setViewName("addcustomer");
		return mv;
	}
	
	@RequestMapping(value = "/updatecustomer" , method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("customer") Customer customer)
	{
		ModelAndView mv = new ModelAndView();
		
        boolean flag = custDao.update(customer);
		
		if(flag)
		{
			mv.addObject("msg","customer is updated");
			List<Customer> customerlist = custDao.gets();
			mv.addObject("customerlist", customerlist);
			mv.setViewName("customerlist");
		}
		else
		{
			mv.addObject("emsg","customer is not updated");
			mv.addObject("customer",customer);
			mv.setViewName("addcustomer");
		}
		return mv;
	}

}
