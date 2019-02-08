<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

<head>
	<title>Registration Form</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Simple Signin Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
	/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="css2/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="css2/font-awesome.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
</head>

<body>
	<!--header-->
	<div class="header-w3l">
		<h1>
			<span>A</span>dd<span> S</span>taff<span></span>
		</h1>
	</div>
	<!--//header-->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<h2>Enter Staff Info</h2>
			<form action="registerStaff.jsp">
				<label>Staff Name</label>
				<div class="pom-agile">
					<span class="fa fa-user-o" aria-hidden="true"></span>
					<input placeholder="Username" name="sname" class="user" type="text" required="">
				</div>
				<label>Staff Password</label>
				<div class="pom-agile">
					<span class="fa fa-key" aria-hidden="true"></span>
					<input placeholder="Password" name="spassword" class="pass" type="password" required="">
				</div>
				<label>Staff Email</label>
				<div class="pom-agile">
					<span class="fa fa-key" aria-hidden="true"></span>
					<input placeholder="Email" name="sEmail" class="pass" type="text" required="">
				</div>
				<label>Department</label>
				<div class="sub-w3l">
					<div class="sub-agile">
						<input type="radio" name="dept_name" value="HR">
						<label for="brand1">
							<span>HR</span></label>
							
						<input type="radio" name="dept_name" value="TECH">
						<label for="brand1">
							<span>TECH</span></label>
							
						<input type="radio" name="dept_name" value="SUPPORT">
						<label for="brand1">
							<span>SUPPORT</span></label>
					</div>
					<!-- <a href="#">Forgot Password?</a> -->
					<div class="clear"></div>
				</div>
				<div class="right-w3l">
					<input type="submit" value="Add Staff">
				</div>
				
			</form>
			<form action="LoginSubmit.jsp">
			<div class="right-w3l">
					<input type="submit" name="Back To Dashboard" value="Back To Dashboard">
				</div>
			</form>
		</div>
	</div>
	<!--//main-->
	<!--footer-->
	<div class="footer">
		<p>&copy; 2018 Add Staff Form. All rights reserved | Design by Nikita-Adnan-Shefali		</p>
	</div>
	<!--//footer-->
</body>

</html>