<?xml version="1.0"?> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<jsp:include page="Header.jsp" />
<head>
   <link rel="stylesheet" href="resources/css/creative.css" type="text/css">
  <title>Candidate Register</title>
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
<%-- <div class="search">
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
					<input type="text" class="form-control" placeholder="Location">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		 </div>
		 <br/><br/> --%>
		 <div class = "register abc">
	<%--  <form class="form-horizontal" action='' method="post">--%>
	
<form:form action="register.htm" commandName="Candidate" method="post">
  <fieldset>
    <div id="legend">
      <legend class="abc"><h2>Candidate Register</h2></legend>
    </div>
	<div class="abc"><h3>Personal Profile</h3></div>
   <%--  <div class='form-group'>
		<label class='control-label col-sm-2'>First Name</label>
			<div class='col-sm-4'>
			<form:input path="firstName" size="30" class='form-control' /><form:errors path="firstName"></form:errors>
			<!--  	<input type='text' class='form-control' name='userName' />-->
			</div>
	</div>	
	
	<div class='form-group'>	
		<label class='control-label col-sm-2'>Last Name</label>
			<div class='col-sm-4'>
			<form:input path="lastName" size="30" class='form-control'/><form:errors path="lastName"></form:errors>
				<!--  <input type='text' class='form-control' name='accountNo' />-->
			</div>
	</div> --%>
	 <div class='form-group'>
		<label class='control-label col-sm-4'>First Name</label>
			<div class='col-sm-6'>
			<form:input path="firstName" size="30" class='form-control' /><form:errors path="firstName"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br />
	<br />
	
	 <div class='form-group'>
		<label class='control-label col-sm-4'>Last Name</label>
			<div class='col-sm-6'>
			<form:input path="lastName" size="30" class='form-control' /><form:errors path="lastName"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br />
	<br />
	
	 <div class='form-group'>
		<label class='control-label col-sm-4'>SSN</label>
			<div class='col-sm-6'>
			<form:input path="ssn" size="30" class='form-control' /><form:errors path="ssn"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br />
	<br />
	
	 <div class='form-group'>
		<label class='control-label col-sm-4'>Address</label>
			<div class='col-sm-6'>
			<form:input path="address" size="30" class='form-control' /><form:errors path="address"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br />
	<br />
	
	 <div class='form-group'>
		<label class='control-label col-sm-4'>Phone</label>
			<div class='col-sm-6'>
			<form:input path="phone" size="30" class='form-control' /><form:errors path="phone"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br />
	<br />
	
	 <div class='form-group'>
		<label class='control-label col-sm-4'>Email</label>
			<div class='col-sm-6'>
			<form:input path="email" size="30" class='form-control' /><form:errors path="email"></form:errors>
				<!-- <input type='email' class='form-control' name='accountNo' /> -->
			</div>
	</div>
	<br />
	<br />
	
	<!-- 
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Password</label>
			<div class='col-sm-4'>
				<input type='password' class='form-control' name='userName' />
			</div>
		<label class='control-label col-sm-2'>Confirm Password</label>
			<div class='col-sm-4'>
				<input type='password' class='form-control' name='accountNo' />
			</div>
	</div>
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Address</label>
			<div class='col-sm-4'>
				<input type='text' class='form-control' name='userName' />
			</div>
		<label for="country" class="col-sm-2 control-label">State</label>
              <div class="col-sm-4">
                        <select id="country" class="form-control">
                            <option>Africa</option>
                            <option>Belgium</option>
                            <option>Cambodia</option>
                            <option>China</option>
                            <option>Denmark</option>
                            <option>Ecuador</option>
                            <option>Ecuador</option>
                            <option>Fiji</option>
                            <option>Gabon</option>
                            <option>Haiti</option>
                            <option>India</option>
                            <option>UK</option>
                            <option>USA</option>
                        </select>
                    </div>
	</div>
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Zip Code</label>
			<div class='col-sm-4'>
				<input type='text' class='form-control' name='userName' />
			</div>
		<label class='control-label col-sm-2'>Contact Number</label>
			<div class='col-sm-4'>
				<input type='text' class='form-control' name='accountNo' />
			</div>
	</div> --><%-- 
	<div><h3>Education Profile </h3>
	<div id="educationDiv">
		<h4>Education Details</h4>
		<div class='form-group'>
			<label class='control-label col-sm-2'>School Name</label>
				<div class='col-sm-4'>
					<form:input class='form-control' path='schoolName' />
				</div>
			<label class='control-label col-sm-2'>Level</label>
				<div class='col-sm-4'>
					<form:input class='form-control' path='level' />
				</div>
		</div>
		<div class='form-group'>
			<label class='control-label col-sm-2'>Year:From</label>
				<div class='col-sm-4'>
					<form:input class='form-control' path='attendedFrom' />
				</div>
			<label class='control-label col-sm-2'>Year:To</label>
				<div class='col-sm-4'>
					<form:input class='form-control' path='attendedTo' />
				</div>
		</div>
		<div class='form-group'>
			<label class='control-label col-sm-2'>Major</label>
				<div class='col-sm-10'>
					<form:input class='form-control' path='major' />
				</div>
		</div>
		<div class='form-group'>
			<label class='control-label col-sm-2'>GPA</label>
				<div class='col-sm-10'>
					<form:input class='form-control' path='gpa' />
				</div>
		</div>
	</div>
	<input type="button" value="Add Education" onclick="addEducationDiv()" /> --%>
	
	
	<!-- <div><h3>Work Profile </h3>
	<div class='form-group'>
		<label class='control-label col-sm-2'>Company Name</label>
			<div class='col-sm-4'>
				<input class='form-control' name='companyName' />
			</div>
		<label class='control-label col-sm-2'>Designation</label>
			<div class='col-sm-4'>
				<input class='form-control' name='designation' />
			</div>
	</div>
	<div class='form-group'>
	<label class='control-label col-sm-2'>Role</label>
			<div class='col-sm-4'>
				<input class='form-control' name='role' />
			</div>
		<label class='control-label col-sm-2'>Year:From</label>
			<div class='col-sm-4'>
				<input class='form-control' name='startDate' />
			</div>
		<label class='control-label col-sm-2'>Year:To</label>
			<div class='col-sm-4'>
				<input class='form-control' name='endDate' />
			</div>
	</div>
	 -->
	<!--  <div class='form-group'>
		<label class='control-label col-sm-2'>Responsibilties</label>
			<div class='col-sm-10'>
				<textarea class='form-control' rows='3' value ='comment' name='description'></textarea>
			</div>
	</div> -->
	<hr/>
	<div class='form-group'>
		<label class='control-label col-sm-4'>Username</label>
			<div class='col-sm-6'>
				<form:input  class='form-control' path='Username' /><form:errors path="username"></form:errors>
		    </div>
	</div>
	<br />
		
	<br />
	
	<div class='form-group'>
		<label class='control-label col-sm-4'>Password</label>
			<div class='col-sm-6'>
				<form:input type='password' class='form-control' path='password' /><form:errors path="password"></form:errors>
			</div>
	</div>
	<br />
	<br />
	</div>

<br/><br/><br/>

		
 
   <div class="control-group">
      <!-- Button -->
      <div class="controls button">
        <input type="submit" value="Register" class="btn btn-info">
      </div>
    </div>
  </fieldset>
  </form:form>
<%--  </form>--%>
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