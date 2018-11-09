<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Company</title>
<link type="text/css"
	href="resources/code/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link type="text/css"
	href="resources/code/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link type="text/css" href="resources/code/css/theme.css"
	rel="stylesheet">
<link type="text/css"
	href="resources/code/images/icons/css/font-awesome.css"
	rel="stylesheet">
<link type="text/css"
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
	rel='stylesheet'>

</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".navbar-inverse-collapse"> <i
					class="icon-reorder shaded"></i></a><a class="brand" href="redirectCandiDash">Company
				</a>
				<div class="nav-collapse collapse navbar-inverse-collapse">

					<ul class="nav pull-right">


						<li class="nav-user dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="images/user.png" class="nav-avatar" /> <b class="caret"></b></a>
							<ul class="dropdown-menu">

								<li><a href="logout.htm?action=logout">Logout</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- /navbar -->
	<div class="wrapper">
		<div class="container">
			<div class="row">
				<div class="span3">
					<div class="sidebar">

						<ul class="widget widget-menu unstyled">
							<li><a href="viewApplicants"><i
									class="menu-icon icon-bold"></i> View Applicants</a></li>

						</ul>

						<ul class="widget widget-menu unstyled">
							<li><a class="collapsed" data-toggle="collapse"
								href="#togglePages"><i class="menu-icon icon-cog"> </i><i
									class="icon-chevron-down pull-right"></i><i
									class="icon-chevron-up pull-right"> </i>More </a>
								<ul id="togglePages" class="collapse unstyled">
									<li><a href="viewCompanyJobs"><i class="icon-inbox"></i>Jobs
									</a></li>
								</ul></li>
							<li><a href="logout.htm?action=logout"><i
									class="menu-icon icon-signout"></i>Logout </a></li>
						</ul>
					</div>
					<!--/.sidebar-->
				</div>
				<!--/.span3-->
				<div class="span9" >


					<div class="module">


						<div class="container" style="float: middle; width: 90%; border: 100">

							<div >
								<div class="register">
									<form:form action="addJob" commandName="job" method="post">
										<fieldset>
											<div id="legend">
												<legend class="">
													<h2>Add Jobs</h2>
												</legend>
												
											</div>
											<div>
												<h3>Add</h3>
											</div>
											<div class='form-group'>
												<label class='control-label col-sm-2'>Job Title</label>
												<div class='col-sm-4'>
													<form:input path="jobTitle" size="30" class='form-control' />
													<form:errors path="jobTitle"></form:errors>
													<!--  	<input type='text' class='form-control' name='userName' />-->
												</div>
											</div>
											<div class='form-group'>
												<label class='control-label col-sm-2'>Description</label>
												<div class='col-sm-4'>
													<form:input path="description" size="30"
														class='form-control' />
													<form:errors path="description"></form:errors>
													<!--  <input type='text' class='form-control' name='accountNo' />-->
												</div>
											</div>
											<div class='form-group'>
												<label class='control-label col-sm-2'>Job Type</label>
												<div class='col-sm-10'>
													<form:input path="jobType" size="30" class='form-control' />
													<form:errors path="jobType"></form:errors>
													<!-- <input type='email' class='form-control' name='accountNo' /> -->
												</div>
											</div>
											<div class='form-group'>
												<label class='control-label col-sm-2'>Salary</label>
												<div class='col-sm-10'>
													<form:input path="salary" size="30" class='form-control' />
													<form:errors path="salary"></form:errors>
													<!-- <input type='email' class='form-control' name='accountNo' /> -->
												</div>
											</div>
											<div class='form-group'>
												<label class='control-label col-sm-2'>Experience
													Required</label>
												<div class='col-sm-10'>
													<form:input path="experienceRequired" size="30"
														class='form-control' />
													<form:errors path="experienceRequired"></form:errors>
													<!-- <input type='email' class='form-control' name='accountNo' /> -->
												</div>
											</div>
											<div class='form-group'>
												<label class='control-label col-sm-2'>Skills
													Required</label>
												<div class='col-sm-10'>
													<form:input path="skillsRequired" size="30"
														class='form-control' />
													<form:errors path="skillsRequired"></form:errors>

												</div>
											</div>


											<div class='form-group'>
												<label class='control-label col-sm-2'>location</label>
												<div class='col-sm-4'>
													<form:input class='form-control' path='location' />
													<form:errors path="location"></form:errors>
												</div>
												<!--  		<div class='col-sm-4'>
				<form:input class='form-control' path='datePosted' /><form:errors path="datePosted"></form:errors>
			</div>-->
											</div>

											<div class='form-group'>
												<label class='control-label col-sm-2'>Qualifications
													Required</label>
												<div class='col-sm-4'>
													<form:input class='form-control'
														path='qualificationsRequired' />
													<form:errors path="qualificationsRequired"></form:errors>
												</div>
												<label class='control-label col-sm-2'>Industry</label>
												<div class='col-sm-4'>
													<form:input class='form-control' path='industry' />
													<form:errors path="industry"></form:errors>
												</div>
											</div>

											<div class="control-group">
												<!-- Button -->
												<div class="controls button">
													<input type="submit" value="Add Job" class="btn btn-info">
												</div>
											</div>
										</fieldset>
									</form:form>
								</div>



							</div>
							<%--  </form>--%>
						</div>


					</div>
				</div>
				<!--/.module-->
			</div>
			<!--/.content-->
		</div>
		<!--/.span9-->
	</div>
	</div>


	<script src="resources/code/scripts/jquery-1.9.1.min.js"
		type="text/javascript"></script>
	<script src="resources/code/scripts/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>
	<script src="resources/code/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="resources/code/scripts/flot/jquery.flot.js"
		type="text/javascript"></script>
	<script src="resources/code/scripts/flot/jquery.flot.resize.js"
		type="text/javascript"></script>
	<script src="resources/code/scripts/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="resources/code/scripts/common.js" type="text/javascript"></script>

</body>
</html>

