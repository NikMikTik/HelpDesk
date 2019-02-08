<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Report Query</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Blend  Login Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css5/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css5/font-awesome.css" rel="stylesheet"> <!-- Font-Awesome-Icons-CSS -->

<!-- //Custom Theme files -->
<!-- web font --> 
<link href="//fonts.googleapis.com/css?family=Vollkorn+SC:400,600,700,900&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Acme" rel="stylesheet"> 
<!-- //web font --> 
</head>
<body>
<%String c=request.getParameter("cId"); %>
	<!-- main -->
	<div class="main">
		<h1>Query Form</h1>
		<div class="main-w3lsrow">
			<!-- login form -->
			<div class="login-form login-form-left"> 
				<div class="agile-row">
					<h2>Enter Query</h2> 
					<div class="login-agileits-top"> 	
						<form action="AddQ.jsp"> 
							<p>Query Description </p>
							<input type="text" class="name" name="qname" required/>
							<p>Issue</p> 
							<!-- <input type="password" class="password" name="Password" required=""/> -->  
							<label class="anim">
								<input type="radio"  name="iss_name" value="HR"><span>HR</span>
								<input type="radio"  name="iss_name" value="TECH"><span>TECH</span>
								<input type="radio"  name="iss_name" value="SUPPORT"><span>SUPPORT</span>
								<input  type="hidden" name="cId" value=<%=c %>>
							<!-- 	<span> Remember me ?</span> --> 
							</label>   
							<input type="submit" value="Submit" name="submit"> 
							
						</form> 
						<form action="LoginSubmit.jsp">
						<input type="submit" value="Back to Dashboard" name="Back to Dashboard"> 
						</form>	
					</div> 
					<div class="login-agileits-bottom"> 
<!-- 						<h6><a href="#">#</a></h6>
 -->					</div> 
					<div class="login-agileits-bottom1"> 
<!-- 						<h3>(or)</h3> -->

					</div> 
					<!-- <div class="social_icons agileinfo">
						<ul class="top-links">
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								</ul>
					</div>
 -->
				</div>  
			</div>  
		</div>	
		<!-- copyright -->
		<div class="copyright">
			<p> © 2018 Query Form. All rights reserved | Design by Nikita-Adnan-Shefali
		</div>
		<!-- //copyright --> 
	</div>	
	<!-- //main --> 
</body>
</html>