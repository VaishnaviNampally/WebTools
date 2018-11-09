
<?xml version="1.0"?> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<jsp:include page="Header.jsp" />
<head>
  <title>Company Register</title>
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
<div class = "container abc" >

		 <div class = "register abc">
	<%--  <form class="form-horizontal" action='' method="post">--%>
	
<form:form action="companySignup" commandName="company" method="post">
  <fieldset>
    <div id="legend abc">
      <legend class="abc"><h2>Register Company</h2></legend>
    </div>
	<div><h3></h3></div>
    <div class='form-group'>
		<label class='control-label col-sm-2'>Company Name</label>
			<div class='col-sm-4'>
			<form:input path="companyName" size="30" class='form-control' /><form:errors path="companyName"></form:errors>
			<!--  	<input type='text' class='form-control' name='userName' />-->
			</div>
		
	</div>
	<br/><br/>
	<hr/>
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Username</label>
			<div class='col-sm-4'>
			<form:input path="username" size="30" class='form-control' /><form:errors path="username"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br/><br/>
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Password</label>
			<div class='col-sm-4'>
			<form:password path="password" size="30" class='form-control' /><form:errors path="password"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br/><br/>
	 	
<br/>

		
 
   <div class="control-group">
      <!-- Button -->
     <!--  <div class="controls button"> -->
        <input type="submit" value="Register" class="btn btn-info">
   
    </div>
  </fieldset>
  </form:form>
<%--  </form>--%>
</div>

</body>

</html>
	<link rel="stylesheet" href="assets/css/bootstrapValidator.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="assets/js/bootstrapValidator.js"></script>
  <script src="functions.js"></script>