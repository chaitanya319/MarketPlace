<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckOut</title>
</head>
<% 
request.getAttribute("msg");
%>
<body>
<p>   In Check Out </p>

<form name="form1" method="post" action="CheckOut">

<div class="form-row"><span class="label">Enter First Name : </span> <input type="text" name="fname" /></div>
<div class="form-row"><span class="label">Enter Last Name : </span> <input type="text" name="lname" /></div>

<div class="form-row"><span class="label">Enter Card number : </span> <input type="text" name="card" /></div>
<div class="form-row"><span class="label">Enter Card Verification number : </span> <input type="text" name="vcard" /></div>
<div class="form-row"><span class="label">Enter email-d : </span> <input type="text" name="email" /></div>

<div class="form-row"><input class="submit" type="submit" name = "submit" value="payment"></div>

</form>

</body>
</html>