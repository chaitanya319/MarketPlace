package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
	int status=1;
	public static ArrayList cart = new ArrayList();
	public static ArrayList temp = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		
	try
	{
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Home h = new Home();
		temp = (ArrayList)h.toAdd();
		
		String a = "test"+request.getParameter("submit2");
		System.out.println("button pressed : " + a);
		
		String a1 = "test"+request.getParameter("submit3");
		System.out.println("button pressed : " + a1);
		
		String a2 = "test"+request.getParameter("submit4");
		System.out.println("button pressed : " + a2);
		
		String a3 = "test"+request.getParameter("submit5");
		System.out.println("button pressed : " + a3);
		
		if(a.equals("testAddtocart"))
		{
			
			System.out.println("In Addto cart");
			String id = request.getParameter("id");
			
			//System.out.println("temp cart is :"+temp);
			
			for(int i=0;i<temp.size();i++)
			{
				String b = (String)temp.get(i);
				if(id.equals(b.substring(0,1)))
				{
					//System.out.println("Add iS :"+b);
					cart.add(b);
				}
			}
			
			System.out.println("cart after add is :"+cart);
			//session.setAttribute("add",temp);
			//System.out.println("Attribute setting in add cart"+temp);
			request.setAttribute("add",temp);
			RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
	        rd.forward(request, response);
		}
		
		if(a1.equals("testdeletefromcart"))
		{
			System.out.println("In delete from cart");
			String id = request.getParameter("id");
			
			for(int i=0;i<cart.size();i++)
			{
				String b = (String)cart.get(i);
				if(id.equals(b.substring(0,1)))
				{
					//System.out.println("Add iS :"+b);
					cart.remove(i);	
					
				}
				
			}
			System.out.println("cart after delete is : "+cart);
			request.setAttribute("add",temp);
			RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
			rd.forward(request, response);
		}
		
		if(a2.equals("testcheckout"))
		{
			System.out.println("In Checkout");
			//new page redirect
			
			request.setAttribute("cart",cart);
			RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
			rd.forward(request, response);
		}
		
		if(a3.equals("testDisplayCart"))
		{
			System.out.println("In Display cart");
			System.out.println("Cart is :" +cart);
			
			request.setAttribute("cart",cart);
			RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
			rd.forward(request, response);
			
		/*	for(int i=0;i<cart.size();i++)
			{
					out.println("Cart is :"+cart.get(i));
		
			}*/
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	//response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Add.jsp");
	}
	
	public ArrayList toAdd()
	{
		System.out.println("In Add before carttransfer to Display is: " +cart);
		return cart;
	}

}
