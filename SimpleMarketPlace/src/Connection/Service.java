package Connection;

import javax.jws.WebService;

@WebService
public class Service {
	
	DatabaseConnection db = new DatabaseConnection();
	
	public String getSold(String tname)
	{
		String result;
		result = db.getSold(tname);
		return result;
	}
	
	public String getBought(String tname)
	{
		String result;
		result = db.getBought(tname);
		return result;
	}
	
	public String updateBought(String username,String itemname)
	{
		String result;
		result = db.updateBought(username, itemname);
		return result;
	}
	
	public String updateSold(String name,String seller)
	{
		String result;
		result = db.updateSold(name, seller);
		return result;
	}
	
	public String update(String name,int qt)
	{
		String result;
		result = db.update(name, qt);
		return result;
	}
	
	public String getAdvertisement()
	{
		String result;
		result = db.getAdvertisement();
		return result;
	}
	
	public String signUp(String fname, String lname, String email, String user, String pwd)
	{
		String result;
		pwd=pwd+"abc";
		result = db.signUp(fname,lname,email,user,pwd);
		return result;
	}
	
	public String signIn(String user, String pass)
	{
		String result;
		result = db.signIn(user);
		int index = result.length();
		index=index-3;
		result=result.substring(0,index);
		System.out.println("In service :password retrived:"+result);
		if(result.equals(pass))
		return "true";
		
		return "false";
	}
	
	public String advertise(String name, String description, String seller, int price, int quantity)
	{
		
		String result;
		result = db.advertise(name,description,seller,price,quantity);
		return result;

	}

}
