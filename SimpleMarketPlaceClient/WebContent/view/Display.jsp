<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Cart has :</p>

<display:table>
<display:column> name </display:column>
<display:column>    description </display:column>
<display:column>    seller </display:column>
<display:column>    price </display:column>
<display:column>    quantity </display:column>
</display:table>

<table>
<% 
	
	List add=(List)request.getAttribute("cart");
	//response.getWriter().print("List:"+add);
	for(int i=0;i<add.size();i++ ){
		%>
		<tr>
		<td>   <%=   add.get(i) %>  </td>
		</tr>
	<%} %>
	
</table>

<form name="form1" method="post" action="Display">

<div class="form-row"> <input class="submit" type="submit" name="submit1" value="checkout" > </div>
<div class="form-row"> <input class="submit" type="submit" name="submit2" value="back" > </div>

</form>
</body>
</html>