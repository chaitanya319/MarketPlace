package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int status =1;
	ServiceProxy proxy = new ServiceProxy();
	public ArrayList temp1 = new ArrayList();
	public static ArrayList temp2 = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		try
		{
	
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		System.out.println("In Home");
		
		String a = "test"+request.getParameter("submitf1");
		System.out.println("button pressed : " + a);
		
		String a1 = "test"+request.getParameter("submitf2");
		System.out.println("button pressed : " + a1);
		
		String a2 = "test"+request.getParameter("submitf3");
		System.out.println("button pressed : " + a2);
		
		
		PrintWriter out; 
		
		System.out.println("First check");
		if(a.equals("testSignout"))
		{
			System.out.println("In Signout loop");
			System.out.println("button pressed : " + a);
			
			
			//Date d = new Date(session.getLastAccessedTime());
			//System.out.println("Last Login " + d.toString());
			out = response.getWriter();
			out.println("Logged out Succesfully!");
			session.invalidate();
			response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/SignIn.jsp");
		}

		if(a2.equals("testviewadvertisement"))
		{
			response.setContentType("text/html");
			//HttpSession session = request.getSession();
		//PrintWriter out = response.getWriter();
		//out.println("Advertisements!");
		String rs = proxy.getAdvertisement();
		String s=rs;
		
		int index =0;
		int cnt=0;
		Integer aind=1;
		
		
		//String [] temp1 = new String[20];
		System.out.println(s.length());
		
		//Maximum 9 advertisements at a time
		
		for(int i=1;i<s.length();i++)
		{
			//int a = index[i-1];
			if(index<s.length()-1)
			{
			cnt = s.indexOf(" row ", index);
			
			String temp = s.substring(index,cnt);
			temp1.add(aind.toString()+temp);
			aind++;

			if(aind==10)
			{
				break;
			}
			
			index=cnt+5;
			
			//System.out.println("index is"+index);
			//System.out.println("a is"+a);
			}
		}	
			//System.out.println("Adds are in temp1 are: "+temp1);
			temp2=temp1;
			//System.out.println("Adds are in temp2 are: "+temp2);
			String username = (String) session.getAttribute("user");
			System.out.println("username"+username);
			
			request.setAttribute("add",temp1);
			RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
	        rd.forward(request, response);
			//response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Add.jsp");
		}
		

		
		System.out.println("outside advertise");
		if(a1.equals("testadvertise"))
		{
			System.out.println("In advertise loop");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String seller = request.getParameter("seller");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");
			out = response.getWriter();
			
			//response.setContentType("text/html");
			//PrintWriter out = response.getWriter();
			
			if(name.equals(""))
			{
				out.println("Enter name of item");
				status=0;
			}
			else if(description.equals(""))
			{
				out.println("Enter item description");
				status=0;
			}
			else if(seller.equals(""))
			{
				out.println("Enter seller information ");
				status=0;
			}
			else if(price.equals(""))
			{
				out.println("Enter price for item");
				status=0;
			}
			else if(quantity.equals(""))
			{
				out.println("Enter quantity of items");
				status=0;
			}
			
			// validations
			if(status==1)
			{
				String res = proxy.advertise(name,description,seller,Integer.parseInt(price),Integer.parseInt(quantity));
				if(res.equals("true"))
				{
					out.println("Advertise saved");
				}
				else
				{
					out.println("Advertise Again");
				}
			}
			
			//After adding go to home page
			response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Home.jsp");
			

		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public ArrayList toAdd()
	{
		System.out.println("In home before transfer temp1 is: " +temp2);
		return temp2;
	}
}
