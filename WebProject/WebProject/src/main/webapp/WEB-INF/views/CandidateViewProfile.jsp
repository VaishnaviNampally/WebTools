<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<style>
.abc {
	background: url("resources/img/header.jpg");
	background-repeat: no-repeat;
	background-size: 1400px 1200px;
	color: white;
}
</style>
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
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
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
			<div class="row ">
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
					<div class="content">

						<div class="module">

							<div class="module-body table ">
								<table border="1" cellpadding="5" cellspacing="5">
									<tr>
										<td><b>Skill Name</b></td>
										<td><b>Skill Type</b></td>

									</tr>
									<c:forEach var="skill" items="${skills}">
										<tr>
											<form action="updateSkill" method="POST">
												<td><input type="text" value="${skill.skillName}"
													name="name">
												<form:errors path="skillName"></form:errors></td>
												<td><input type="text" value="${skill.skillType}"
													name="type">
												<form:errors path="skillType"></form:errors></td>

												<td><input type="hidden" value="${skill.skillID}"
													name="skillID"> <input type="hidden"
													value="${skill.skillName}" name="skillName"> <input
													type="hidden" value="${skill.skillType}" name="skillType">
													<input type="submit" value="update" name="update"></td>
												<form>
										</tr>
									</c:forEach>

								</table>
								</br> </br>

								<table border="1" cellpadding="5" cellspacing="5">
									<tr>
										<td><b>School Name</b></td>
										<td><b>Level</b></td>
										<td><b>Major</b></td>
										<td><b>Attended From</b></td>
										<td><b>Attended To</b></td>
										<td><b>GPA</b></td>

									</tr>
									<c:forEach var="edu" items="${edus}">
										<tr>
											<form action="updateEdu" method="POST">
												<td><input type="text" value="${edu.schoolName}"
													name="schoolName">
												<form:errors path="schoolName"></form:errors></td>
												<td><input type="text" value="${edu.level}"
													name="level">
												<form:errors path="level"></form:errors></td>
												<td><input type="text" value="${edu.major}"
													name="major">
												<form:errors path="major"></form:errors></td>
												<td><div class="input-group date"
														data-provide='datepicker'>
														<input type="text" value="${edu.attendedFrom}"
															name="attendedFrom">
														<form:errors path="attendedFrom"></form:errors>
														<span class='form-group input-group-addon add-on '>
															<button type="button" class="btn btn-info">
																<span class='glyphicon glyphicon-calendar'></span>
															</button>
														</span>
													</div></td>
												<td><div class="input-group date"
														data-provide='datepicker'>
														<input type="text" value="${edu.attendedTo}"
															name="attendedTo">
														<form:errors path="attendedTo"></form:errors>
														<span class='form-group input-group-addon add-on '>
															<button type="button" class="btn btn-info">
																<span class='glyphicon glyphicon-calendar'></span>
															</button>
														</span>
													</div></td>
												<td><input type="text" value="${edu.GPA}" name="gpa">
												<form:errors path="GPA"></form:errors></td>
												<td><input type="hidden" value="${edu.educationID}"
													name="eduID"> <input type="submit" value="update"
													name="update"></td>

												<!--  <td> <form action="sendToEmployer"> <input type="submit" value="apply"></form></td> -->

											</form>
										</tr>
									</c:forEach>
								</table>
								</br> </br>
								<table border="1" cellpadding="5" cellspacing="5">
									<tr>
										<td><b>Company Name</b></td>
										<td><b>Role</b></td>
										<td><b>description</b></td>
										<td><b>startDate</b></td>
										<td><b>endDate</b></td>

									</tr>
									<form action="updateExp" method="POST">
										<c:forEach var="exp" items="${exps}">
											<tr>
												<td><input type="text" value="${exp.companyName}"
													name="companyName">
												<form:errors path="companyName"></form:errors></td>
												<td><input type="text" value="${exp.role}" name="role">
												<form:errors path="role"></form:errors></td>
												<td><input type="text" value="${exp.description}"
													name="description">
												<form:errors path="description"></form:errors></td>
												<td><div class="input-group date"
														data-provide='datepicker'>
														<input type="text" value="${exp.startDate}"
															name="startDate">
														<form:errors path="startDate"></form:errors>
														<span class='form-group input-group-addon add-on '>
															<button type="button" class="btn btn-info">
																<span class='glyphicon glyphicon-calendar'></span>
															</button>
														</span>
													</div></td>
												<td><div class="input-group date"
														data-provide='datepicker'>
														<input type="text" value="${exp.endDate}" name="endDate">
														<form:errors path="endDate"></form:errors>
														<span class='form-group input-group-addon add-on '>
															<button type="button" class="btn btn-info">
																<span class='glyphicon glyphicon-calendar'></span>
															</button>
														</span>
													</div></td>
												<td><input type="hidden" value="${exp.experienceId}"
													name="expID"> <input type="submit" value="update"
													name="update"></td>
									</form>
									</tr>
									</c:forEach>
								</table>
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
<script>
$(document).ready(function() {
    $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            //$('#eventForm').formValidation('revalidateField', 'attendedFrom');
			alert("change");
        });
});
</script>
</html>
