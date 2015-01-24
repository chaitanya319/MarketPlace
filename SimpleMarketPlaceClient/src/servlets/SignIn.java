package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();   
	int status=1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String msg ="";
		response.setContentType("text/html");
		proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/Service");
		System.out.println("In SignIn servlets");
		try
		{
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			
			String sc = "~!@#$%^&*";
			char a2[] = sc.toCharArray();
			
			//validation if fields are empty
			if(pass.equals(""))
			{
				out.println("Fill Password");
				status=0;
			}
			
			if(user.equals(""))
			{
				out.println("Fill User Name");
				status=0;
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
			if(status ==1)
			{
				String result = proxy.signIn(user,pass);
				if(result.equals("true"))
				{
					//out.println("User Validated");
					session.setAttribute("user",user);
					//session.setAttribute("user1",user+"second");			
					//request.getRequestDispatcher("http://localhost:8080/SimpleMarketPlaceClient/view/home.jsp").forward(request, response);
					//System.out.println("Last login time :" + d.toString());
					//session.setAttribute();
					
					//Date d = new Date(session.getLastAccessedTime());
					//d.toString();
					//msg="User Validated";
					//session.setAttribute("msg",msg);
					//session.setAttribute(d.toString(),session);
					response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Home.jsp");
				}
				else
				{
					//msg="wrong User Validated";
					//session.setAttribute("msg",msg);
					out.println("Wrong Validation \n Please Sign In Again");
					response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/SignIn.jsp");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
