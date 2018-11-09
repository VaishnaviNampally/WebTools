<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Candidate</title>
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
					class="icon-reorder shaded"></i></a><a class="brand"
					href="redirectCandidateDash">Candidate </a>
				<div class="nav-collapse collapse navbar-inverse-collapse">

					<ul class="nav pull-right">


						<li class="nav-user dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="images/user.png" class="nav-avatar" /> <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="viewProfile">Your Profile</a></li>

								<li class="divider"></li>
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
							<li><a href="manageSkill"><i class="menu-icon icon-bold"></i>
									Skill </a></li>
							<li><a href="manageEducation"><i
									class="menu-icon icon-book"></i>Education </a></li>
							<li><a href="manageExperience"><i
									class="menu-icon icon-paste"></i>Experience </a></li>
							<li><a href="show"><i class="menu-icon icon-table"></i>Upload
									resume </a></li>
						</ul>

						<ul class="widget widget-menu unstyled">
							<li><a class="collapsed" data-toggle="collapse"
								href="#togglePages"><i class="menu-icon icon-cog"> </i><i
									class="icon-chevron-down pull-right"></i><i
									class="icon-chevron-up pull-right"> </i>More </a>
								<ul id="togglePages" class="collapse unstyled">
									<li><a href="viewQualifiedJobs"><i class="icon-inbox"></i>Applications
									</a></li>
									<li><a href="listjobs"><i class="icon-inbox"></i>Jobs
									</a></li>
								</ul></li>
							<li><a href="logout.htm?action=logout"><i
									class="menu-icon icon-signout"></i>Logout </a></li>
						</ul>
					</div>
					<!--/.sidebar-->
				</div>
				<!--/.span3-->
				<div class="span9">



					<div class="module">


						<div class="container"
							style="float: middle; width: 90%; border: 100">

							<div class="register">

								<div align="center">
									<h1>Upload Resume</h1>
									<form method="post" action="doUpload"
										enctype="multipart/form-data">
										<table border="0">
											<tr>
												<td>Pick file</td>
												<td><input type="file" required name="fileUpload" size="50" /></td>
												<form:errors path="data"></form:errors>
											</tr>

											<tr>
												<td colspan="2" align="center"><input type="submit"
													value="Upload" /></td>
											</tr>
										</table>
									</form>

									<a href="download">Resume</a>
								</div>

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
	<!--/.container-->
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

