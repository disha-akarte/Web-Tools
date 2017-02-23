<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    

    <!-- Bootstrap core CSS -->
    <link href="resources/assets1/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="resources/assets1/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="resources/assets1/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="resources/assets1/css/style.css" rel="stylesheet">
    <link href="resources/assets1/css/style-responsive.css" rel="stylesheet">




</head>
    <body> 
        <div class="col-md-8  search">
             <form class="navbar-form" action="searchJobs.htm">
                    <select class="form-control" name="searchBy">
 						 <option value="location">Location</option>
 						 <option value="company">Company</option>
 						 <option value="type">Type</option>
 						 <option value="category">Category</option>
					</select>          
                        <input class="form-control" placeholder="Search" type="text" name="searchText" />
                        <!-- <input class="btn btn-default" type="submit" value="Search"> <i class="glyphicon glyphicon-search"></i></input> -->
                        <input class="btn btn-default" type="submit" action="searchJobs.htm">
								<i class="glyphicon glyphicon-search"></i>
						</input> 
                       
             </form>
         </div>
 
        <div class="container">
        <table class="table table-bordered">
             <thead>
            <tr>
                
                <th><b>Title</b></th>
                <th><b>Type</b></th>
                <th><b>Description</b></th>
                <th><b>Salary</b></th>
                <th><b>Experience Required</b></th>
                <th><b>Skills required</b></th>
                <th><b>Qualifications Required</b></th>
                <th><b>Location</b></th>
                <th><b>Category</b></th>
                <th><b>Company</b></th>
                <th><b>Date Posted</b></th>
                <th><b>Action</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${jobs}">
                <tr>
                	<td>${job.jobTitle}</td>                                                     
                    <td>${job.jobType}</td>
                    <td>${job.jobDescription}</td>
                    <td>${job.salary}</td>
                    <td>${job.experienceRequired}</td>
                    <td>${job.skillsRequired}</td>                                      
                    <td>${job.qualifications}</td>
                    <td>${job.location}</td>
                    <td>${job.category}</td>
                    <td>${job.postedBy}</td>
                    <td>${job.datePosted}</td>
                    <td> <form action="applyJob">
                    <input type="hidden" value="${job.jobID}" name="jobID">
                    <input type="submit" value="Apply" /></form></td>
                 </tr>
 			 </c:forEach>
             </tbody>
        	</table>
         </div>
    </body>
    
     <!-- js placed at the end of the document so the pages load faster -->
    <script src="resources/assets1/js/jquery.js"></script>
    <script src="resources/assets1/js/jquery-1.8.3.min.js"></script>
    <script src="resources/assets1/js/bootstrap.min.js"></script>

    <!--common script for all pages-->
    <script src="resources/assets1/js/common-scripts.js"></script>
</html>