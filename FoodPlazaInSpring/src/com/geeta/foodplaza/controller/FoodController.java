package com.geeta.foodplaza.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.geeta.foodplaza.dao.FoodDao;
import com.geeta.foodplaza.pojo.Food;
import com.sun.org.apache.xerces.internal.util.URI;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

//this controller class method which all the client request handler method
@Controller
public class FoodController
{
	
	//Automatically foodDao bean in inject using @Autowired annotation.
	@Autowired
	FoodDao foodDao;
	@Autowired
	private JavaMailSender mailSender;
	
	//it should be execute by default
	
	@GetMapping(value={"/", "/home"})
	public String home(HttpSession session)
	{
		List<Food> flist = foodDao.gets();
		//model.addAttribute("foodlist", flist);
		session.setAttribute("foodlist", flist);
		return "index";
	}
	
	@RequestMapping("/home")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/addfood")
	public String showFoodForm()
	{
		return "addfood";
	}
	
	@RequestMapping(value = "/savefood",method = RequestMethod.POST,  consumes = MediaType.IMAGE_JPEG_VALUE)
	public ModelAndView save(@ModelAttribute("food") Food food,@RequestParam("file") MultipartFile foodImage) throws IOException
	{
		ModelAndView mv = new ModelAndView();
		
		food.setFoodImage(foodImage.getBytes());
		
		int id = foodDao.save(food);
		
		mv.addObject("msg", "Food is added successfully..");
		mv.addObject("foodId", id);
		mv.setViewName("addfood");
		return mv;
	}
	
	@RequestMapping(value = "foodlist")
	public ModelAndView list(HttpSession session,HttpServletRequest req)
	{
		try
		{
		// creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("abhayc008@gmail.com");
        email.setSubject("test");
        email.setText("testS");
         
        // sends the e-mail
        mailSender.send(email);
        /*
        mailSender.send(new MimeMessagePreparator() {
        	  public void prepare(MimeMessage mimeMessage) throws MessagingException {
        	    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        	    message.setFrom(fromEmail);
        	    message.setTo(toEmail);
        	    message.setSubject("A file for you");
        	    message.setText("<b>See the attached</b>", true);
        	    message.addAttachment("CoolStuff.doc", new File("CoolStuff.doc"));
        	  }
        	});
        	*/
        	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//url......../FoodPlazaInSpring/foodlist
		//foodlist
		/*
		System.out.println("url........" +req.getRequestURI());	
		String url = req.getRequestURI();
		url = url.substring(url.lastIndexOf("/")+1, url.length());
		System.out.println(url);
		*/
		ModelAndView mv = new ModelAndView();
		List<Food> foodlist = foodDao.gets();
		//mv.addObject("foodlist", foodlist);//request scope
		session.setAttribute("foodlist", foodlist);//session scope
		mv.setViewName("foodlist");
		return mv;
	}
	
	@RequestMapping(value = "deletefood")
	public ModelAndView delete(@RequestParam("foodId") int foodId)
	{
		ModelAndView mv = new ModelAndView();
		boolean flag = foodDao.delete(foodId);
	
		if(flag)
			mv.addObject("msg","Food is deleted");
		else
			mv.addObject("emsg","Food is not deleted");
			
		List<Food> foodlist = foodDao.gets();
		mv.addObject("foodlist", foodlist);
		mv.setViewName("foodlist");
		return mv;
	}
	
	@RequestMapping(value = "/editfood")
	public ModelAndView edit(@RequestParam("foodId") int foodId)
	{
		ModelAndView mv = new ModelAndView();
		Food food = foodDao.getById(foodId);
		mv.addObject("food",food);
		mv.addObject("action","update");
		mv.setViewName("addfood");
		return mv;
	}
	
	@RequestMapping(value = "/updatefood" , method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("food") Food food, @RequestParam("file") MultipartFile foodImage ) throws IOException
	{
		ModelAndView mv = new ModelAndView();
		
		if(foodImage.getSize()!=0)
		{
			food.setFoodImage(foodImage.getBytes());
		}
		else
		{
			//if you dont want to get update old image from database.
			Food f = foodDao.getById(food.getFoodId());
			food.setFoodImage(f.getFoodImage());
		}
        boolean flag = foodDao.update(food);
		
		if(flag)
		{
			mv.addObject("msg","Food is updated");
			List<Food> foodlist = foodDao.gets();
			mv.addObject("foodlist", foodlist);
			mv.setViewName("foodlist");
		}
		else
		{
			mv.addObject("emsg","Food is not updated");
			mv.addObject("food",food);
			mv.setViewName("addfood");
		}
		return mv;
	}
	
	@GetMapping(value = "/foodimage", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] foodimage(@RequestParam("foodId") int foodId) throws Exception 
	{
		Food food = foodDao.getById(foodId);
		if(food != null)
		{
		return food.getFoodImage();
		}
		return null;
	}	
}
