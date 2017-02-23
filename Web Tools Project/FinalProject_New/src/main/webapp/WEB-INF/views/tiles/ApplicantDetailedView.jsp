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
    
    <div class="container">
    
        <table class="table table-bordered">
             <thead>
            <tr>                
            	<th><b>Application ID</b></th>
                <th><b>Job Title</b></th>
                <th><b>Candidate Name</b></th>
                <th><b>Application Status</b></th>
                <th><b>Action</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="app" items="${eav}" >
                <tr>
                	<td>${app.appID}</td>
                	<td>${app.jobTitle}</td> 
                	<td><a href="candProfile.htm?candID=${app.candidateID}">${app.name}</a></td>
                	
                	<td>${app.status}</td>   
                	<td><form action="acceptCandidate.htm">
                    <input type="hidden" value="${app.appID}" name="appID">
                    <input type="submit" value="Accept" /></form>
                    <form action="rejectCandidate">
                    <input type="hidden" value="${app.appID}" name="appID">
                    <input type="submit" value="Reject" /></form></td>                                               
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