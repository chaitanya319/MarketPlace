package servlets;

import java.io.*;
import java.net.Inet4Address;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;
/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
	int status=1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone;
		try
		{
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			
			//Check if any field is empty
			if(email.equals(""))
			{
				out.println("Fill email");
				status=0;
			}
			else if(fname.equals(""))
			{
				out.println("Fill First Name");
				status=0;
			}
			else if(lname.equals(""))
			{
				out.println("Fill Last Name");
				status=0;
			}
			else if(pass.equals(""))
			{
				out.println("Fill Password");
				status=0;
			}
			else if(user.equals(""))
			{
				out.println("Fill User Name");
				status=0;
			}
			
			//Check if fname contains only character
			char a[] = fname.toCharArray();
			for(int i=0;i<fname.length();i++)
			{
				if(Character.isDigit(a[i]))
				{
					out.println("Invalid FirstName");
					status=0;
					break;
				}
			}
			
			//Check if lname contains only character
			char a1[] = lname.toCharArray();
			for(int i=0;i<lname.length();i++)
			{
				if(Character.isDigit(a1[i]))
				{
					out.println("Invalid LastName");
					status=0;
					break;
				}
			}
			
			//email validation
			String s = email;
			int index = s.indexOf('@');
			if(-1==index)
			{
				out.println("invalid e-mail");
				status=0;
			}
			
			String part1 = s.substring(0,index);
			//System.out.println(part1);
			
			String part2 = s.substring(index+1);
			//System.out.println(part2);
			
			String sc = "~!@#$%^&*";
			char a2[] = sc.toCharArray();
			//System.out.println(a2.length);
			//System.out.println(part1.length());
			
			for(int i=0;i<a2.length;i++)
			{
				if(-1==part1.indexOf(a2[i]))
				{}
				else
				{
					out.println("Email has special character");
					status=0;
					break;
				}
			}
			
			if(part2.indexOf(".")==-1)
			{
				out.println("Invalid email");
				status=0;
			}
			
			char temp[] = part2.toCharArray();
			
			for(int i=0;i<a2.length;i++)
			{
				if(-1==part2.indexOf(a2[i]))
				{}
				else
				{
					out.println("Email has special character");
					status=0;
					break;
				}
			
			}
			for(int i=0;i<temp.length;i++)
			{
				if(Character.isDigit(temp[i]))
				{
					out.println("Invalid email");
					status=0;
					break;
				}
			}
			
			
			//validating username
			for(int i=0;i<a2.length;i++)
			{
				if(-1==user.indexOf(a2[i]))
				{}
				else
				{
					out.println("Invalid username has special character");
					status=0;
					break;
				}
				
			}
			
			//validating password
			for(int i=0;i<a2.length;i++)
			{
				if(-1==pass.indexOf(a2[i]))
				{}
				else
				{
					out.println("Invalid password has special character");
					status=0;
					break;
				}
			}
			
			HttpSession session = request.getSession();
			proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/Service");
			
			if(status==1)
			{
				
				qdone = proxy.signUp(fname,lname,email,user,pass);
				if(qdone.substring(0,4).equals("true"))
				{
					//given
					//session.setAttribute(user,session);
					session.setAttribute("user",user);
					out.println("Welcome : "+user);
					response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Home.jsp");
				}
				else
				{
					out.println(qdone.substring(6));
					out.println("SignUp Again");
					response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/signUp.jsp");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
