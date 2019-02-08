<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="zxx">

<head>
<title>ONLINE HELP DESK</title>
<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Switch Login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta-Tags -->
<!-- Index-Page-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<!-- //Custom-Stylesheet-Links -->
<!--fonts -->
<link
	href="//fonts.googleapis.com/css?family=Mukta+Mahee:200,300,400,500,600,700,800"
	rel="stylesheet">
<!-- //fonts -->
<!-- Font-Awesome-File-Links -->
<link rel="stylesheet" href="css/font-awesome.css" type="text/css"
	media="all">
</head>

<body>
	<h1 class="title-agile text-center">ONLINE HELP DESK</h1>
	<div class="content-w3ls">
		<div class="content-top-agile">
			<h2>sign in</h2>
		</div>
		<div class="content-bottom">
					
		<%
		if( request.getParameter("check")!=null && request.getParameter("check").equals("fail")){
			out.println("<center><h2>INVALID</h2></center>");	
		}
		%>		
			<form action="Validate.jsp" method="get">
				<div class="field-group">
					<span class="fa fa-user" aria-hidden="true"></span>
					<div class="wthree-field">
						<input name="nme" id="text1" type="text"
							placeholder="Username" required>
					</div>
				</div>
				<div class="field-group">
					<span class="fa fa-lock" aria-hidden="true"></span>
					<div class="wthree-field">
						<input name="pwd" id="password" type="Password"
							placeholder="Password" required>
					</div>
				</div>
				<ul class="list-login">
					<!-- <li class="switch-agileits">
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                            keep me signed in
                        </label>
                    </li> -->
					<!-- <li><a href="Register.jsp" class="text-right">Register
							Here!</a></li>
					<li class="clearfix"></li> -->
				</ul>
				<div class="wthree-field">
					<input id="saveForm" name="saveForm" type="submit" value="sign in" />
				</div>
				<br>
				
			</form>
			<form action="Register.html">
			<div class="wthree-field">
					<input id="saveForm" name="register" type="submit" value="Register here" /></a>
				</div>
				</form>
				
	
		</div>
	</div>
	<div class="copyright text-center">
		<p>
			© 2018 Switch Login Form. All rights reserved | Design by <a
				href="http://w3layouts.com">Nikita|Shefali|Adnan</a>
		</p>
	</div>
</body>
<!-- //Body -->

</html>