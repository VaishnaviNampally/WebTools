<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Candidate</title>
        <link type="text/css" href="resources/code/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="resources/code/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="resources/code/css/theme.css" rel="stylesheet">
        <link type="text/css" href="resources/code/images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
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
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i></a><a class="brand" href="redirectCandidateDash">Candidate </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                    
                        <ul class="nav pull-right">
                           
                            
                            <li class="nav-user dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="images/user.png" class="nav-avatar" />
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="viewProfile">Your Profile</a></li>
                                    <li class="divider"></li>
                                    <li><a href="logout.htm?action=logout">Logout</a></li>
                                </ul>
                            </li>
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
                                <li><a href="manageSkill"><i class="menu-icon icon-bold"></i> Skill </a></li>
                                <li><a href="manageEducation"><i class="menu-icon icon-book"></i>Education </a></li>
                                <li><a href="manageExperience"><i class="menu-icon icon-paste"></i>Experience </a></li>
                                <li><a href="show"><i class="menu-icon icon-table"></i>Upload resume </a></li>
                            </ul>
                            
                            <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#togglePages"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>More </a>
                                    <ul id="togglePages" class="collapse unstyled">
                                        <li><a href="viewQualifiedJobs"><i class="icon-inbox"></i>Applications </a></li>
                                        <li><a href="listjobs"><i class="icon-inbox"></i>Jobs </a></li>
                                    </ul>
                                </li>
                                <li><a href="logout.htm?action=logout"><i class="menu-icon icon-signout"></i>Logout </a></li>
                            </ul>
                        </div> 
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                            
                         
                            <div class="module">
                               
                                <div class = "container" style="float: middle; width: 90%; border: 100">

		 <div class = "register">
	
<form:form action="addEducation" commandName="education" method="post">
  <fieldset>
    <div id="legend">
      <legend class=""><h2>Add Education</h2></legend>
    </div>
	<div><h3>Add</h3></div>
    <div class='form-group'>
		<label class='control-label col-sm-2'>School Name</label>
			<div class='col-sm-4'>
			<form:input path="schoolName" size="30" class='form-control' /><form:errors path="schoolName"></form:errors>
			<!--  	<input type='text' class='form-control' name='userName' />-->
			</div>
		<label class='control-label col-sm-2'>Level</label>
			<div class='col-sm-4'>
			<form:input path="level" size="30" class='form-control'/><form:errors path="level"></form:errors>
				<!--  <input type='text' class='form-control' name='accountNo' />-->
			</div>
	</div>
	
	 <div class='form-group'>
		<label class='control-label col-sm-2'>Major</label>
			<div class='col-sm-4'>
			<form:input path="major" size="30" class='form-control' /><form:errors path="major"></form:errors>
			<!--  	<input type='text' class='form-control' name='userName' />-->
			</div>
		<label class='control-label col-sm-2'>GPA</label>
			<div class='col-sm-4'>
			<form:input path="GPA" size="30" class='form-control'/><form:errors path="GPA"></form:errors>
				<!--  <input type='text' class='form-control' name='accountNo' />-->
			</div>
	</div>
	 <div class='form-group  input-group date' data-provide='datepicker'>
		<label class='control-label col-sm-2'>Attended From</label>
			<div class='col-sm-4'>
			<form:input path="attendedFrom" size="30" class='form-control' /><form:errors path="attendedFrom"></form:errors>
			<span class='form-group input-group-addon add-on '> 
							<button type="button" class="btn btn-info">
						  		<span class='glyphicon glyphicon-calendar'></span>
							</button></span>
			
			</div>
			</div>
		<div class='form-group  input-group date' data-provide='datepicker'>	
		<label class='control-label col-sm-2'>Attended To</label>
			<div class='col-sm-4'>
			<form:input path="attendedTo" size="30" class='form-control'/><form:errors path="attendedTo"></form:errors>
				<span class='form-group input-group-addon add-on '> 
							<button type="button" class="btn btn-info">
						  		<span class='glyphicon glyphicon-calendar'></span>
							</button></span>


			</div>
			</div>
			<div class="control-group">
      <!-- Button -->
      <div class="controls button">
        <input type="submit" value="Add" class="btn btn-info">
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
            <!--/.container-->
        </div>
        
        <script src="resources/code/scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="resources/code/scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="resources/code/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/code/scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="resources/code/scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="resources/code/scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
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
    
