

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
                <th><b>Skill Name</b></th>
                <th><b>Action</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="skill" items="${skills}">
                <tr>
                	<td>${skill.skillName}</td>
                	<td> 
                	<form action="deleteCandidateSkill">
                    <input type="hidden" value="${skill.skillId}" name="skillId">
                    <input type="submit" value="Delete" /></form></td>                                                          
                 </tr>
 			 </c:forEach>
             </tbody>
        	</table>
         </div>
</body>
</html>