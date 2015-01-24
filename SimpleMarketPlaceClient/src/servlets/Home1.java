package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ServiceProxy;

/**
 * Servlet implementation class Home1
 */
public class Home1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int status =1;
	ServiceProxy proxy = new ServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home1() {
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
		
		System.out.println("In home1");
	
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String seller = request.getParameter("seller");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
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
			/*String res = proxy.advertise(name,description,seller,price,quantity);
			if(res.equals("true"))
			{
				out.println("Advertise saved");
			}
			else
			{
				out.println("Advertise Again");
			}*/
		}
		else
		{
			response.sendRedirect("http://localhost:8080/SimpleMarketPlaceClient/view/Home.jsp");
		}
		
		
	}

}
