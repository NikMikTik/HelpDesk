<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String qc=request.getParameter("cId");
/* String[] p=qc.split("_");
String qq=p[0];
String c=p[1];
String[] pp=c.split("=");
String cc=pp[1];
int t=Integer.parseInt(qq); */
int tt=Integer.parseInt(qc);
System.out.println("tt is"+tt);
Customer q=new Customer();
if(q.delC(tt))
{out.println("Customer Deleted");
response.sendRedirect("ViewCustomer.jsp");
out.println("<a href='ViewCustomer.jsp'>Back to list</a>");}
 else
	{System.out.println("Sorry,Cant Delete it...");
	out.println("<a href='ViewCustomer.jsp'>Back to list</a>");}
	
/* response.sendRedirect("ViewQ.jsp"); */
%>
<!-- q.delQ(qi) -->
</body>
</html>