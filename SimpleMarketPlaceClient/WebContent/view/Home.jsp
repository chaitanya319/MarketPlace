<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>

<style>
body
{
	text-align: centre;
}
</style>

<body>
<p> </p>
<% 
	Date d = new Date(session.getLastAccessedTime());
response.getWriter().print(session.getAttribute("user"));
response.getWriter().print(" ");
	response.getWriter().print("Last Accessed time : "+d.toString());
	//response.getWriter().print("Welcome "+session.getAttribute(session));
%>
					
<form name="form" method="post" action="Home">
<div class="form-row"> <input class="submit" type="submit" name="submitf1" value="Signout" > </div>
</form>

<form name="form1" method="post" action="Home">
<p> Put My Advertisement</p>

<div class="form-row"><span class="label">item_name :</span> <input type="text" name="name" /></div>
<div class="form-row"><span class="label">item_description :</span> <input type="text" name="description" /></div>

<div class="form-row"><span class="label">Seller_information :</span> <input type="text" name="seller" /></div>
<div class="form-row"><span class="label">Price :</span> <input type="text" name="price" /></div>

<div class="form-row"><span class="label">Quantity :</span> <input type="text" name="quantity" /></div>

<div class="form-row"><input class="submit" type="submit" name = "submitf2" value="advertise"></div>

</form>

<form name="form3" method="post" action="Home">
<div class="form-row"> <input class="submit" type="submit" name="submitf3" value="viewadvertisement" > </div>
</form>

</body>
</html>