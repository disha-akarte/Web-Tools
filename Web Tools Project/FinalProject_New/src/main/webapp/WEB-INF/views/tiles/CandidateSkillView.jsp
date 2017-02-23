<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<ul class="nav nav-tabs">
  <li><a href="candProfile.htm?candID=${candidate.id}">Personal Details</a></li>
  <li class="active"><a href="CandidateSkillView?candID=${candidate.id}">Skills</a></li>
  <li><a href="CandidateCareerViewCompany?candID=${candidate.id}">Career</a></li>
   <li><a href="CandidateEducationViewCompany?candID=${candidate.id}">Education</a></li>
</ul>

		 <div class="container">
        <table class="table table-bordered">
             <thead>
            <tr>           
                <th><b>Skill Name</b></th>
             
            </tr>
            </thead>
            <tbody>
            <c:forEach var="skill" items="${skills}">
                <tr>
                	<td>${skill.skillName}</td>
                	                	                                                      
                 </tr>
 			 </c:forEach>
             </tbody>
        	</table>
         </div>
	

</body>
</html>