<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final</title>
</head>


<body>

<p><b>Items Are</b> :</p>

<display:table>
<display:column> <b>Name</b> </display:column>
</display:table>

<table>
<% 
	
    List add1=(List)request.getAttribute("items");
	//response.getWriter().print("List:"+add);
	for(int i=0;i<add1.size();i++ ){
		%>
		<tr>
		<td>   <%=   add1.get(i) %>  </td>
		</tr>
	<%} %>
	
</table>


<form name="form1" method="post" action="Final">

<div class="form-row"><input class="submit" type="submit" name = "submit1" value="CheckSoldItems"></div>
<div class="form-row"><input class="submit" type="submit" name = "submit2" value="CheckBoughtItems"></div>
<div class="form-row"><input class="submit" type="submit" name = "submit3" value="Home"></div>

</form>


</body>
</html>