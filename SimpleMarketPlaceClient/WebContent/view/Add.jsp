<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addvertisements</title>
</head>

<style>
body
{
	text-align: centre;
}
</style>

<body>
<display:table>
<display:column> name </display:column>
<display:column> description </display:column>
<display:column> seller </display:column>
<display:column> price </display:column>
<display:column> quantity </display:column>
</display:table>

<table>
<% 
	

	List add=(List)request.getAttribute("add");
	//response.getWriter().print("List:"+add);
	for(int i=0;i<add.size();i++ ){
		%>
		<tr>
		<td> <%= add.get(i)  %>   </td>
		</tr>
	<%} %>
	</table>

<p>Advertisement ID is First letter<p>
<form name="form2" method="post" action="Add">

<div class="form-row"><span class="label">Enter AddId :</span> <input type="text" name="id" /></div>
<div class="form-row"> <input class="submit" type="submit" name="submit2" value="Addtocart" > </div>

</form>

<form name="form3" method="post" action="Add">

<div class="form-row"><span class="label">Enter AddId :</span> <input type="text" name="id" /></div>
<div class="form-row"> <input class="submit" type="submit" name="submit3" value="deletefromcart" > </div>

</form>

<form name="form4" method="post" action="Add">

<div class="form-row"> <input class="submit" type="submit" name="submit4" value="checkout" > </div>

</form>

<form name="form5" method="post" action="Add">

<div class="form-row"> <input class="submit" type="submit" name="submit5" value="DisplayCart" > </div>

</form>


</body>
</html>