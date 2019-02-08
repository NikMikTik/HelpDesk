<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Query"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String qc=request.getParameter("qId");
String[] p=qc.split("_");
String qq=p[0];
String c=p[1];
String[] pp=c.split("=");
String cc=pp[1];
int t=Integer.parseInt(qq);
int tt=Integer.parseInt(cc);
System.out.println("tt is"+tt);
Query q=new Query();
if(q.delQ(t))
{out.println("Query Deleted");
response.sendRedirect("ViewQ.jsp");

out.println("<a href='ViewQ.jsp'>View Tables</a>");}
 else
	{System.out.println("Sorry,Cant Delete it...");
	out.println("<a href='ViewQ.jsp'>View Tables</a>");}
	
/* response.sendRedirect("ViewQ.jsp"); */
%>
<!-- q.delQ(qi) -->
</body>
</html>