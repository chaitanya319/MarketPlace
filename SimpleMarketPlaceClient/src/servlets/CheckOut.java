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
 * Servlet implementation class CheckOut
 */
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServiceProxy proxy = new ServiceProxy();
	public static ArrayList cart = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
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
		try{
		Display d = new Display();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//System.out.println("In check out cart"+request.getParameter("cart"));
		String msg="";
		//session.getAttributeNames();
		String temp = request.getParameter("card");
		String temp1 = request.getParameter("vcard");
		if((temp.length()==16) && (temp1.length()==3))
		{
			msg="Transaction Successfull!";
			cart = d.getCart();
			System.out.println("In Transaction :"+cart);
			int index;
			String n1;
			Object o = new Object();
			o = session.getAttribute("user");
			String nm  = o.toString();
			System.out.println("Username in check out is:"+nm);
			
			for(int i=0;i<cart.size();i++)
			{
					//get new element
					String temp3 = (String)cart.get(i);
					index = temp3.lastIndexOf(" ");
					n1 = temp3.substring(1,index);
					temp = n1;
					
					System.out.println("element :"+temp);
					//get name from string	
					index = n1.indexOf(" ");
					String name = n1.substring(0,index);
					System.out.println("name :"+name);
					
					//get quantity
					index = n1.lastIndexOf(" ");
					String q = n1.substring(index+1);
					
					int qt = Integer.parseInt(q);
					
					System.out.println("Item name is :"+name);
					System.out.println("qt is :"+qt);
					String rs="true";
					if(qt>1)
					rs = proxy.update(name,qt);
					if(rs.equals("true"))
					{
						System.out.println("Database updated for update!");
					}
					
					//updating user accounts for solds
					index = n1.indexOf(" ");
					String t = n1.substring(index+1);
					index = t.indexOf(" ");
					
					t = t.substring(index+1);
					
					int index1 = t.indexOf(" ");
					t = t.substring(0,index1);
					String seller = t;
					
					System.out.println("Seller is :"+seller);
					System.out.println("Name is :"+name);
					//System.out.println("name :"+name);
					rs=proxy.updateSold(name,seller);
					if(rs.equals("true"))
					{
						System.out.println("Database updated for Sold!");
					}
			
					//update database for bought pass username and name of product
					System.out.println("username: "+nm+"itemname:"+name);
					rs=proxy.updateBought(nm,name);

					if(rs.equals("true"))
					{
						System.out.println("Database updated for Bought!");
					}

			}	
			ArrayList e = new ArrayList();
			
			request.setAttribute("items",e);
			RequestDispatcher rd = request.getRequestDispatcher("Final.jsp");
	        rd.forward(request, response);
			
			
			
		}
		else
		{
			msg = "Enter Valid card Details and try Again!";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("CheckOut.jsp");
	        rd.forward(request, response);
		}
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
