package servlet_demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String name= request.getParameter("t1");
		String password = request.getParameter("t2");
		
		PrintWriter out = response.getWriter();
		
		if(name.equals("admin") && password.equals("admin")) 
		{
			RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}
		else 
		{
			out.print("Invalid Credentials!!!");
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
