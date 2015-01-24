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

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList cart = new ArrayList();
	public static ArrayList adds = new ArrayList();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
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
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			
			Add c = new Add();
			cart = c.toAdd();
			
			Home h1 = new Home();
			adds = h1.toAdd();
		
			//request.getParameter("cart");
			
			String a = "test"+request.getParameter("submit1");
			System.out.println("button pressed : " + a);
		
			String a1 = "test"+request.getParameter("submit2");
			System.out.println("button pressed : " + a1);
		
			if(a.equals("testcheckout"))
			{
				System.out.println("button pressed : " + a);
				//cart = (ArrayList)h.toAdd();
				System.out.println("Cart before checkout : " + cart);
				request.setAttribute("cart",cart);
				RequestDispatcher rd = request.getRequestDispatcher("CheckOut.jsp");
		        rd.forward(request, response);
			}
			
			if(a1.equals("testback"))
			{
				System.out.println("button pressed : " + a1);
				System.out.println("Cart before checkout at back: " + cart);
				request.setAttribute("add",adds);
				RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
		        rd.forward(request, response);
				//response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Add.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public ArrayList getCart()
	{
		return cart;
	}

}
