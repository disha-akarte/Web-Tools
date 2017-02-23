

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <div class="container">
        <table class="table table-bordered">
             <thead>
            <tr>           
                <th><b>Company Name</b></th>
                <th><b>Description</b></th>
                <th><b>Designation</b></th>
                <th><b>Role</b></th>
                <th><b>Start Date</b></th>
                <th><b>End Date</b></th>
                <th><b>Action</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="car" items="${career}">
                <tr>
                	<td>${car.companyName}</td>
                	<td>${car.description}</td>
                	<td>${car.designation}</td>
                	<td>${car.role}</td>
                	<td>${car.startDate}</td>
                	<td>${car.endDate}</td>
                	<td> 
                	<form action="deleteCandidateCareer">
                    <input type="hidden" value="${car.careerID}" name="careerID">
                    <input type="submit" value="Delete" /></form></td>                                                          
                 </tr>
 			 </c:forEach>
             </tbody>
        	</table>
         </div>
</body>
</html>