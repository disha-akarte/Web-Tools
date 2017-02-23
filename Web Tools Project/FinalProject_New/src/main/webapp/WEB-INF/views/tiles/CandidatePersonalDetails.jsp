

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
								<form:form role="form" action="updatecandidate.htm"
											class="registration-form" commandName="candidate" method="post">									
									<div class="form-group">
										First Name:
										<form:input path="first" size="30" name="form-location" value ="${candidate.first}"
											class="form-location form-control"
											id="form-last-name" />
										<font color="red"><form:errors path="first" /></font>
										
									</div>
									<div class="form-group">
										Last Name : 
										<form:input path="last" size="30" name="form-location" value ="${candidate.last}"
											class="form-location form-control"
											id="form-last-name" />
									    <font color="red"><form:errors path="last" /></font>
									</div>
									
									<div class="form-group">
										Phone:
										<form:input path="phone" size="30" name="form-location" value ="${candidate.phone}"
											class="form-location form-control"
											id="form-last-name" />
										<font color="red"><form:errors path="phone" /></font>
									</div>
									
									<div class="form-group">
										Address:
										<form:input path="address" size="30" name="form-location" value ="${candidate.address}"
											class="form-location form-control"
											id="form-last-name" />
										<font color="red"><form:errors path="address" /></font>
									</div>
									
									<div class="form-group">
											Resume: 
											<a href="viewResume.htm?candid=${candidate.id}">Link to Resume</a>
											<input type="hidden" name='candID' value='${candidate.id}'/>
									</div>
									
									<!-- <input type="submit" class="btn">Sign me up! -->
									<button type="submit" class="btn">Update!</button>
								</form:form>

</body>
</html>