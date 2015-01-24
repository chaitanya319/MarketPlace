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
 * Servlet implementation class Final
 */
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
	
	public static ArrayList slist = new ArrayList();
	public static ArrayList blist = new ArrayList();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final() {
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
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		//get the user name
		Object o = new Object();
		o = session.getAttribute("user");
		String nm  = o.toString();
		System.out.println("Username in final is:"+nm);
		
		String a = "test"+request.getParameter("submit1");
		System.out.println("button pressed : " + a);
		
		String a1 = "test"+request.getParameter("submit2");
		System.out.println("button pressed : " + a1);
		
		String a2 = "test"+request.getParameter("submit3");
		System.out.println("button pressed : " + a2);

		
		if(a.equals("testCheckSoldItems"))
		{
			System.out.println("In dispsold");
			String result1 = proxy.getSold(nm);	
			System.out.println("Sold Items are : " + result1);
			String s = result1;
			
			for(;;)
			{
				int cnt = s.lastIndexOf(" ");
				int index = s.indexOf(" ");
				String temp = s.substring(0,index);
				slist.add(temp);
				s=s.substring(index+1);
				
				if(cnt == index)
				break;
				
			}
			System.out.println("Sold Items list is : " + slist);
			
			request.setAttribute("items",slist);
			RequestDispatcher rd = request.getRequestDispatcher("Final.jsp");
	        rd.forward(request, response);
			
		}
		
		if(a1.equals("testCheckBoughtItems"))
		{
			System.out.println("In dispbought");
			String result2 = proxy.getBought(nm);
			System.out.println("Bought items are" + result2);
			
			String s = result2;
			
			for(;;)
			{
				int cnt = s.lastIndexOf(" ");
				int index = s.indexOf(" ");
				String temp = s.substring(0,index);
				blist.add(temp);
				s=s.substring(index+1);
				
				if(cnt == index)
				break;
				
			}
			System.out.println("Bought Items list is : " + blist);
			
			request.setAttribute("items",blist);

			
			RequestDispatcher rd = request.getRequestDispatcher("Final.jsp");
	        rd.forward(request, response);
			
		}
		
		if(a2.equals("testHome"))
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
	        rd.forward(request, response);
			
		}
	}
}
