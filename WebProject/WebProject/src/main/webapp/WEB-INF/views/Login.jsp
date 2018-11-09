<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
  body{
		margin:10px;
		background:url("resources/img/header.jpg");
		background-repeat:no-repeat;
		background-size:1400px 1200px ;
		color:white;
		}
	.search{
		margin-left:50px;
	}
	.register{
		margin-left:50px;
		margin-top:50px;
	}
	.button{
			margin-left:500px;
	}
	.abc{
			font-family: Merriweather,'Helvetica Neue',Arial,sans-serif;
		 	color: #ffffff;
	}
  </style>
</head>
<body>

<div class = "container">

		 <div class = "register abc">
	 <form class="form-horizontal" action='userlogin.htm' method="post">
	
<%--  <form:form action="login.htm" commandName="Candidate" method="post">--%>
  <fieldset>
    <div id="legend">
      <legend class="abc"><h2>Login</h2></legend>
    </div>
	<div><h3>Enter username and password</h3></div>
    <div class='form-group'>
		<label class='control-label col-sm-2'>Username</label>
			<div class='col-sm-4'>
			
			 	<input type='text' class='form-control' name='username' />
			</div>
		
	</div>
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Password</label>
			<div class='col-sm-4'>
			
			<input type='password' class='form-control' name='password' />
			</div>
	</div>
	  <div class='form-group'>
		<label class='control-label col-sm-2'></label>
			<div class='col-sm-4'>
			
			
			</div>
	</div>


			 

		
   <div class="control-group">
      <!-- Button
      <div class="controls button"> -->
      
        <input type="submit" value="Login" class="btn btn-info">
      <!--  </div>-->
    </div>
  </fieldset>
</form>
</div>
</div>
</body>
</html>
	<link rel="stylesheet" href="assets/css/bootstrapValidator.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="assets/js/bootstrapValidator.js"></script>
  <script src="functions.js"></script>