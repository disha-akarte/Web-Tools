

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
                <th><b>School Name</b></th>
                <th><b>Level</b></th>
                <th><b>Major</b></th>
                <th><b>Year Attended From</b></th>
                <th><b>Year Attended To</b></th>
                <th><b>Action</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="edu" items="${education}">
                <tr>
                	<td>${edu.schoolName}</td>
                	<td>${edu.level}</td>
                	<td>${edu.major}</td>
                	<td>${edu.yearAttendedFrom}</td>
                	<td>${edu.yearAttendedTo}</td>
                	
                	<td> 
                	<form action="deleteCandidateEdu">
                    <input type="hidden" value="${edu.eduId}" name="eduId">
                    <input type="submit" value="Delete" /></form></td>                                                          
                 </tr>
 			 </c:forEach>
             </tbody>
        	</table>
         </div>
</body>
</html>