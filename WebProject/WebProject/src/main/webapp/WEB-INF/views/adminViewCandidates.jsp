<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
 <style>
	.abc{
			
		background:url("resources/img/header.jpg");
		background-repeat:no-repeat;
		background-size:1400px 1200px ;
		color:white;
	}
  </style>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin</title>
        <link type="text/css" href="resources/code/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="resources/code/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="resources/code/css/theme.css" rel="stylesheet">
        <link type="text/css" href="resources/code/images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
    </head>
    <body >
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i></a><a class="brand" href="#">Admin </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                    
                        <ul class="nav pull-right">
                           
                            
                            <li class="nav-user dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="images/user.png" class="nav-avatar" />
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
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
                <div class="row " >
                    <div class="span3">
                        <div class="sidebar">
                        
                            <ul class="widget widget-menu unstyled">
                                <li><a href="viewCandidates"><i class="menu-icon icon-bold"></i> View Candidates </a></li>
                                <li><a href="viewCompanies"><i class="menu-icon icon-table"></i>View Companies</a></li>
                            </ul>
                         
                        </div> 
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                            
                            <!--/#btn-controls-->
                          
                            <!--/.module-->
                           
                            <div class="module">
                <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>Candidate ID</b></td>
                <td><b>Candidate Name</b></td>
                
            </tr>
            <c:forEach var="job" items="${cand}">
                <tr>
                    <td>${job.userID}</td>
                    <td>${job.firstName}</td>
                    
                  <!--  <td> <form action="sendToEmployer"> <input type="submit" value="apply"></form></td> 
                    <td><form action="deleteCandidate" method="POST"><input type="hidden" value="${job.userID}" name="userID"><input type="submit" value="Delete Candidate"></form></td>-->
                </tr>
            </c:forEach>
        </table>

                                
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
