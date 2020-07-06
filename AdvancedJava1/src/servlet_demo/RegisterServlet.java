package servlet_demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  String name,password,gender;
		  int contactno;
		  
		  name = request.getParameter("name");
		  password = request.getParameter("password");
		  gender = request.getParameter("gender");
		  String [] hobbies = request.getParameterValues("hobbies");
		  contactno = Integer.parseInt(request.getParameter("contactno"));
		        
		  PrintWriter out = response.getWriter();
		  
		  out.print("<table>");
		  out.print("<tr><td>Name:</td><td>  " +name+ "</td></tr><br>");
		  out.print("<tr><td> Password:</td><td>  " +password+ "</td></tr><br>");
		  out.print("<tr><td> Gender:</td><td>  " +gender+ "</td><td><br>");
		  out.print("<tr><td> Hobbies are:</td></tr>");
		  
		  /*for(int i=0;i<hobbies.length;i++)
	       {
			  out.println("<tr><td>"+hobbies[i]+"</td><tr>");
	       }*/
		  
		  for(String hob: hobbies) 
		  {
			  out.print("<tr><td>"+hob+"</td><tr>");
		  }
		  out.print("<tr><td> Contact No:  " +contactno+ "</tr></td>");
		  out.print("</table>");
		  
	}

}
