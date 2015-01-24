<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="Connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String name_1id=  request.getParameter("name18");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        String qt_2id=  request.getParameter("qt20");
        int qt_2idTemp  = Integer.parseInt(qt_2id);
        java.lang.String update15mtemp = sampleServiceProxyid.update(name_1idTemp,qt_2idTemp);
if(update15mtemp == null){
%>
<%=update15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(update15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String fname_3id=  request.getParameter("fname25");
            java.lang.String fname_3idTemp = null;
        if(!fname_3id.equals("")){
         fname_3idTemp  = fname_3id;
        }
        String lname_4id=  request.getParameter("lname27");
            java.lang.String lname_4idTemp = null;
        if(!lname_4id.equals("")){
         lname_4idTemp  = lname_4id;
        }
        String email_5id=  request.getParameter("email29");
            java.lang.String email_5idTemp = null;
        if(!email_5id.equals("")){
         email_5idTemp  = email_5id;
        }
        String user_6id=  request.getParameter("user31");
            java.lang.String user_6idTemp = null;
        if(!user_6id.equals("")){
         user_6idTemp  = user_6id;
        }
        String pwd_7id=  request.getParameter("pwd33");
            java.lang.String pwd_7idTemp = null;
        if(!pwd_7id.equals("")){
         pwd_7idTemp  = pwd_7id;
        }
        java.lang.String signUp22mtemp = sampleServiceProxyid.signUp(fname_3idTemp,lname_4idTemp,email_5idTemp,user_6idTemp,pwd_7idTemp);
if(signUp22mtemp == null){
%>
<%=signUp22mtemp %>
<%
}else{
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
}
break;
case 35:
        gotMethod = true;
        String name_8id=  request.getParameter("name38");
            java.lang.String name_8idTemp = null;
        if(!name_8id.equals("")){
         name_8idTemp  = name_8id;
        }
        String seller_9id=  request.getParameter("seller40");
            java.lang.String seller_9idTemp = null;
        if(!seller_9id.equals("")){
         seller_9idTemp  = seller_9id;
        }
        java.lang.String updateSold35mtemp = sampleServiceProxyid.updateSold(name_8idTemp,seller_9idTemp);
if(updateSold35mtemp == null){
%>
<%=updateSold35mtemp %>
<%
}else{
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateSold35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
}
break;
case 42:
        gotMethod = true;
        String username_10id=  request.getParameter("username45");
            java.lang.String username_10idTemp = null;
        if(!username_10id.equals("")){
         username_10idTemp  = username_10id;
        }
        String itemname_11id=  request.getParameter("itemname47");
            java.lang.String itemname_11idTemp = null;
        if(!itemname_11id.equals("")){
         itemname_11idTemp  = itemname_11id;
        }
        java.lang.String updateBought42mtemp = sampleServiceProxyid.updateBought(username_10idTemp,itemname_11idTemp);
if(updateBought42mtemp == null){
%>
<%=updateBought42mtemp %>
<%
}else{
        String tempResultreturnp43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateBought42mtemp));
        %>
        <%= tempResultreturnp43 %>
        <%
}
break;
case 49:
        gotMethod = true;
        String name_12id=  request.getParameter("name52");
            java.lang.String name_12idTemp = null;
        if(!name_12id.equals("")){
         name_12idTemp  = name_12id;
        }
        String description_13id=  request.getParameter("description54");
            java.lang.String description_13idTemp = null;
        if(!description_13id.equals("")){
         description_13idTemp  = description_13id;
        }
        String seller_14id=  request.getParameter("seller56");
            java.lang.String seller_14idTemp = null;
        if(!seller_14id.equals("")){
         seller_14idTemp  = seller_14id;
        }
        String price_15id=  request.getParameter("price58");
        int price_15idTemp  = Integer.parseInt(price_15id);
        String quantity_16id=  request.getParameter("quantity60");
        int quantity_16idTemp  = Integer.parseInt(quantity_16id);
        java.lang.String advertise49mtemp = sampleServiceProxyid.advertise(name_12idTemp,description_13idTemp,seller_14idTemp,price_15idTemp,quantity_16idTemp);
if(advertise49mtemp == null){
%>
<%=advertise49mtemp %>
<%
}else{
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(advertise49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
}
break;
case 62:
        gotMethod = true;
        java.lang.String getAdvertisement62mtemp = sampleServiceProxyid.getAdvertisement();
if(getAdvertisement62mtemp == null){
%>
<%=getAdvertisement62mtemp %>
<%
}else{
        String tempResultreturnp63 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAdvertisement62mtemp));
        %>
        <%= tempResultreturnp63 %>
        <%
}
break;
case 65:
        gotMethod = true;
        String user_17id=  request.getParameter("user68");
            java.lang.String user_17idTemp = null;
        if(!user_17id.equals("")){
         user_17idTemp  = user_17id;
        }
        String pass_18id=  request.getParameter("pass70");
            java.lang.String pass_18idTemp = null;
        if(!pass_18id.equals("")){
         pass_18idTemp  = pass_18id;
        }
        java.lang.String signIn65mtemp = sampleServiceProxyid.signIn(user_17idTemp,pass_18idTemp);
if(signIn65mtemp == null){
%>
<%=signIn65mtemp %>
<%
}else{
        String tempResultreturnp66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signIn65mtemp));
        %>
        <%= tempResultreturnp66 %>
        <%
}
break;
case 72:
        gotMethod = true;
        String tname_19id=  request.getParameter("tname75");
            java.lang.String tname_19idTemp = null;
        if(!tname_19id.equals("")){
         tname_19idTemp  = tname_19id;
        }
        java.lang.String getBought72mtemp = sampleServiceProxyid.getBought(tname_19idTemp);
if(getBought72mtemp == null){
%>
<%=getBought72mtemp %>
<%
}else{
        String tempResultreturnp73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getBought72mtemp));
        %>
        <%= tempResultreturnp73 %>
        <%
}
break;
case 77:
        gotMethod = true;
        String tname_20id=  request.getParameter("tname80");
            java.lang.String tname_20idTemp = null;
        if(!tname_20id.equals("")){
         tname_20idTemp  = tname_20id;
        }
        java.lang.String getSold77mtemp = sampleServiceProxyid.getSold(tname_20idTemp);
if(getSold77mtemp == null){
%>
<%=getSold77mtemp %>
<%
}else{
        String tempResultreturnp78 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getSold77mtemp));
        %>
        <%= tempResultreturnp78 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>