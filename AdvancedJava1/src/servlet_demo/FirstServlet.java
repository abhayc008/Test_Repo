package servlet_demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Go")//Web Annotation came in 3.0 version
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
          //System.out.println("Hello");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
		  String str = request.getParameter("name");
		  int str1 = Integer.parseInt(request.getParameter("no1"));
		  int str2 = Integer.parseInt(request.getParameter("no2"));
		  
		  int add = str1 + str2;
      
		  PrintWriter out = response.getWriter();
		  out.print("<b> Hello  " +str+ "</b><br>");
		  out.print("<b> Addition  " +add+ "</b");
	}

}

