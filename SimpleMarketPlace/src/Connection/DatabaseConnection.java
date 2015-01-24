package Connection;

import java.sql.*;

public class DatabaseConnection
{
	Connection con = null;
	Statement stmt = null;
	static ResultSet rs;
 
	DatabaseConnection()
	{
		try
		{
			System.out.println("In DB con");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
			stmt = con.createStatement();
			
			if(!con.isClosed())
			{
				System.out.println("Connected successfully!!");
			}
		}
		catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public String getSold(String tname)
	{
		String result="";
		String temp="";
		try
		{
		
			System.out.println("Getting Sold for :"+tname);
			String query = "SELECT sold FROM " + tname + " where bought='" + "" + "'";
			
			rs = stmt.executeQuery(query);
		
			System.out.println("get sold Query Executed");
		
			while(rs.next())
			{
				
				temp=rs.getString("sold");	
				System.out.println("name of item sold is :"+ temp);
				temp = temp+" ";
				result = result+temp;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String getBought(String tname)
	{
		String result="";
		String temp="";
		try
		{
		
			System.out.println("Getting Bought for :"+tname);
			String query = "SELECT bought FROM "+tname+" where sold='"+""+"'";
			
			rs = stmt.executeQuery(query);
		
			System.out.println("get bought Query Executed");
		
			while(rs.next())
			{
				
				temp=rs.getString("bought");	
				System.out.println("name of item bought is :"+ temp);
				temp = temp+" ";
				result = result+temp;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String updateBought(String username,String itemname)
	{
		
		String result="";
		int rowcount=0;
		try
		{
			System.out.println("Updating Bought");
			System.out.println("with:" +username +itemname);
			String query = "Insert into "+ username +" (sold, bought) values ('" + "" + "','" + itemname + "')";
			System.out.println("before updateBought query");
			rowcount = stmt.executeUpdate(query);
			System.out.println("exe query");
			if(rowcount>0)
			{
				result="true";
				//System.out.println("Insert Succesfull!");
			}
			else
			{
				result="False:data could not be inserted!";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String updateSold(String name,String seller)
	{
		
		String result="";
		int rowcount=0;
		try
		{
			System.out.println("Updating Sold");
			System.out.println("with:" +seller +name);
			String query = "Insert into "+ seller +" (sold, bought) values ('" + name + "', '" + "" + "')";
			System.out.println("before exe query");
			rowcount = stmt.executeUpdate(query);
			System.out.println("exe query");
			if(rowcount>0)
			{
				result="true";
				//System.out.println("Insert Succesfull!");
			}
			else
			{
				result="False:data could not be inserted!";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	
	public String update(String name,int qt)
	{
		String result="";
		int rowcount=0;
		try
		{
			qt--;
		
			System.out.println("Updating advertise");
			String query = "update advertise set quantity='" + qt + "' where name= '" + name + "'";
			System.out.println("Update Query Executed on advertise");
			rowcount = stmt.executeUpdate(query);
		
			
			
			if(rowcount>0)
			{
				result="true";
			}
			else
			{
				result="False";
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	public String getAdvertisement()
	{
		String result="";
		String temp="";
		try
		{
		
			System.out.println("Getting Advertisements");
			String query = "SELECT * FROM advertise";
			
			rs = stmt.executeQuery(query);
		
			System.out.println("get advertise Query Executed");
		
			while(rs.next())
			{
			
				result=rs.getString("name");
				result =result+" ";
				//System.out.println("name of item :"+ result);
				
				result=result+rs.getString("description");
				result =result+" ";
				//System.out.println("description of item :"+ result);
				
				result=result+rs.getString("seller");
				result =result+" ";
				//System.out.println("seller of item :"+ result);
				
				result=result+rs.getString("price");
				result =result+" ";
				//System.out.println("price of item :"+ result);
				
				result=result+rs.getString("quantity");
				result =result+" ";
				//System.out.println("quantity of item :"+ result);
				
				temp = temp+result+" row ";
				System.out.println("temp :"+ temp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return temp;
	}
	
	public String signUp(String fname, String lname, String email, String user, String pwd)
	{
		String result="";
		int rowcount;
		try
		{
			System.out.println("Entering data to table");
			String query = "Insert into customer (firstname, lastname, email, username, password) values ('" + fname + "', '" + lname + "', '" + email + "','" + user + "','" + pwd +"')";
			rowcount = stmt.executeUpdate(query);
			//System.out.println("row count is : " + rowcount);
			
			if(rowcount>0)
			{
				result="true";
				//System.out.println("Insert Succesfull!");
			}
			else
			{
				result="False:data could not be inserted!";
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String signIn(String user)
	{
		String result="";
		
		try
		{
			System.out.println("Checking data in table to validate");
			String query = "SELECT password FROM customer where username='"+user+"'";
			
			System.out.println("Query Executed with username"+user);
			rs = stmt.executeQuery(query);
			rs.next();
			result=rs.getString("password");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String advertise(String name, String description, String seller, int price, int quantity)
	{
		String result="false";
		try
		{
			System.out.println("Enter Advertise");
			String query = "Insert into advertise (name, description, seller, price, quantity) values ('" + name + "', '" + description + "', '" + seller + "', '" + price + "', '" + quantity + "')";
			
			int rowcount = stmt.executeUpdate(query);
			System.out.println("row count is : " + rowcount);
			
			if(rowcount>0)
			{
				result="true";
				System.out.println("Insert Succesfull!");
			}
			else
			{
				result="False:data could not be inserted!";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}
