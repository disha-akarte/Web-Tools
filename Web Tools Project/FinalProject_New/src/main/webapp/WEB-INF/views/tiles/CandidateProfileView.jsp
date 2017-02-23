<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<ul class="nav nav-tabs">
  <li class="active" ><a href="candProfile.htm?candID=${candidate.id}">Personal Details</a></li>
  <li><a href="CandidateSkillView?candID=${candidate.id}">Skills</a></li>
  <li><a href="CandidateCareerViewCompany?candID=${candidate.id}">Career</a></li>
  <li ><a href="CandidateEducationViewCompany?candID=${candidate.id}">Education</a></li>
</ul>

		<form role="form" action="updatecandidate.htm"
											class="registration-form" commandName="candidate" method="post">				
			<h1>Candidate Details</h1>
			<div class="form-group">
			<b>First Name :</b>
			${candidate.first}
			</div>
			<div class="form-group">
			<b>Last Name</b> 
			${candidate.last}
			</div>
			<div class="form-group">
			<b>Phone</b> 
			${candidate.phone}
			</div>
			<div class="form-group">
			<b>Address</b> 
			${candidate.last}
			</div>
			<div class="form-group">
			<b>Resume</b> 
			<a href="viewResume.htm?candid=${candidate.id}">Link to Resume</a>
			</div>
		</form>

</body>
</html>