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
    <link rel="stylesheet" type="text/css" href="resources/assets1/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="resources/assets1/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="resources/assets1/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="resources/assets1/css/style.css" rel="stylesheet">
    <link href="resources/assets1/css/style-responsive.css" rel="stylesheet">

    <script src="resources/assets1/js/chart-master/Chart.js"></script>
    
</head>
<body>

  <div class="row">
                  <div class="col-lg-9 main-chart">         
                   <div class="row">
                  
                  <div class="col-md-10 col-sm-10 mb">              
                   <form:form role="form" action="addskills.htm"
									class="registration-form" commandName="skills">
									<div class="form-group">
										Skill Name
										<form:input path="skillName" size="30" name="form-skill-name"
											placeholder="Skill"
											class="form-first-name form-control" id="form-skill-name" />
										<font color="red"><form:errors path="skillName" /></font>
									</div>
					
									<input type="submit" class="btn" value="Add Skill"/>
								</form:form>
                   </div>
                   </div>
                   
                  
					</div>
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->

</body>

<!-- js placed at the end of the document so the pages load faster -->
    <script src="resources/assets1/js/jquery.js"></script>
    <script src="resources/assets1/js/jquery-1.8.3.min.js"></script>
    <script src="resources/assets1/js/bootstrap.min.js"></script>

    <!--common script for all pages-->
    <script src="resources/assets1/js/common-scripts.js"></script>
</html>