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
int cc=(Integer)session.getAttribute("cId");
String req=(String)request.getParameter("Response");
String q=(String)request.getParameter("qId");
int qid=Integer.parseInt(q);
Query qq=new Query();
if(qq.giveResponse(req,qid)==true)
{out.println("Response Added");
response.sendRedirect("ViewSQ.jsp");}
%>
<a href="LoginSubmit.jsp">Go to Dashboard</a>
</body>
</html>