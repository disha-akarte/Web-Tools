<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
    <link rel="stylesheet" type="text/css" href="resources/assets1/css/zabuto_calendar.css"/>
    <link rel="stylesheet" type="text/css" href="resources/assets1/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="resources/assets1/lineicons/style.css"/>    
    
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
                           	
                      	
                   
                   <form:form role="form" action="addjob.htm"
									class="registration-form" commandName="job" method="post">
									<div class="form-group">
										Job Title
										<form:input path="jobTitle" size="30" name="form-job-title"
											placeholder="Job Title"
											class="form-first-name form-control" id="form-job-title" />
										<font color="red"><form:errors path="jobTitle" /></font>
									</div>
									<div class="form-group">
										Job Description
										<form:input path="jobDescription" size="30" name="form-job-description"
											placeholder="Enter Job Description" class="form-last-name form-control"
											id="form-job-description" />
										<font color="red"><form:errors path="jobDescription"/></font>
									</div>
									<div class="form-group">
										Job Type
										<form:input path="jobType" size="30"
											name="form-job-type" placeholder="Job Type"
											class="form-email form-control" id="form-job-Type" />
										<font color="red"><form:errors path="jobType" /></font>
									</div>
									<div class="form-group">
										Experience Required
										<form:input path="experienceRequired" size="30"
											name="form-exp-required" placeholder="Experience Required"
											class="form-email form-control" id="form-exp-required" />
											<font color="red"><form:errors path="experienceRequired" /></font>
									</div>
									<div class="form-group">
										Salary
										<form:input path="salary" size="30" name="form-salary"
											placeholder="Salary" class="form-location form-control"
											id="form-salary" />
											<font color="red"><form:errors path="salary" /></font>
									</div>
									<div class="form-group">
										Skills Required
										<form:input path="skillsRequired" size="30" name="form-skillsRequired"
											placeholder="Skills Required" class="form-location form-control"
											id="form-skillsRequired" />
											<font color="red"><form:errors path="skillsRequired" /></font>
									</div>
									<div class="form-group">
										Qualifications
										<form:input path="qualifications" size="30" name="form-qualifications"
											placeholder="Qualifications" class="form-location form-control"
											id="form-qualifications" />
										<font color="red"><form:errors path="qualifications" /></font>
									</div>
									<div class="form-group">
										Location
										<form:input path="location" size="30" name="form-location"
											placeholder="Location" class="form-location form-control"
											id="form-location" />
										<font color="red"><form:errors path="location" /></font>
									</div>
									
									<div class="form-group">
										Category
										<form:input path="category" size="30" name="form-location"
											placeholder="Category" class="form-location form-control"
											id="form-category" />
										<font color="red"><form:errors path="category" /></font>
									</div>
									<button type="submit" class="btn">Add Job</button>
								</form:form>
                   
                   </div>
                   </div>
                   
                  
					</div>
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->

</body>

<!-- js placed at the end of the document so the pages load faster -->
      <script src="resources/assets1/js/bootstrap.min.js"></script>

    <!--common script for all pages-->
    <script src="resources/assets1/js/common-scripts.js"></script>
</html>