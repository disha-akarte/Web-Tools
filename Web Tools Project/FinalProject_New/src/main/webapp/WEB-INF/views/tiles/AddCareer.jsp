<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">



<!-- Bootstrap core CSS -->
<link href="resources/assets1/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="resources/assets1/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="resources/assets1/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="resources/assets1/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css"
	href="resources/assets1/lineicons/style.css">

<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>



<!-- Custom styles for this template -->
<link href="resources/assets1/css/style.css" rel="stylesheet">
<link href="resources/assets1/css/style-responsive.css" rel="stylesheet">

<script src="resources/assets1/js/chart-master/Chart.js"></script>

</head>
<body>

	<div class="container">
		<div class="col-lg-9 main-chart">



			<div class="row">

				<div class="col-md-10 col-sm-10 mb">



					<form:form role="form" action="addCareer.htm"
						class="registration-form" commandName="career" method="post">
						<div class="form-group">
							Company Name
							<form:input path="companyName" size="30" name="form-job-title"
								placeholder="companyName" class="form-first-name form-control"
								id="form-job-title" />
							<font color="red"><form:errors path="companyName" /></font>
						</div>
						<div class="form-groupinput-group date" data-provide='datepicker'>
							Start Date
							<form:input path="startDate" size="30"
								name="form-job-description" placeholder="startDate"
								class="form-last-name form-control" id="form-job-description" />
							<font color="red"><form:errors path="startDate" /></font>
							<span
								class='form-group input-group-addon add-on '>
								<button type="button" class="btn btn-info">
									<span class='glyphicon glyphicon-calendar'></span>
								</button>
							</span>

						</div>
						<div class="form-group input-group date" data-provide='datepicker'>
							End Date
							<form:input path="endDate" size="30" name="form-job-type"
								placeholder="endDate" class="form-email form-control"
								id="form-job-Type" />
							<font color="red"><form:errors path="endDate" /></font>
							<span
								class='form-group input-group-addon add-on '>
								<button type="button" class="btn btn-info">
									<span class='glyphicon glyphicon-calendar'></span>
								</button>
							</span>
						</div>
						<div class="form-group">
							Role
							<form:input path="role" size="30" name="form-exp-required"
								placeholder="role" class="form-email form-control"
								id="form-exp-required" />
							<font color="red"><form:errors path="role" /></font>
						</div>
						<div class="form-group">
							Designation
							<form:input path="designation" size="30" name="form-salary"
								placeholder="designation" class="form-location form-control"
								id="form-salary" />
							<font color="red"><form:errors path="designation" /></font>
						</div>

						<div class="form-group">
							Description
							<form:input path="description" size="30"
								name="form-qualifications" placeholder="description"
								class="form-location form-control" id="form-qualifications" />
							<font color="red"><form:errors path="description" /></font>
						</div>

						<button type="submit" class="btn">Add Career</button>
					</form:form>
				</div>
			</div>
		</div>


	</div>
	</div>
	<!-- /col-lg-9 END SECTION MIDDLE -->

</body>

<!-- js placed at the end of the document so the pages load faster -->
<script src="resources/assets1/js/jquery.js"></script>
<script src="resources/assets1/js/jquery-1.8.3.min.js"></script>
<script src="resources/assets1/js/bootstrap.min.js"></script>

<script>
$(document).ready(function() {
    $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            //$('#eventForm').formValidation('revalidateField', 'attendedFrom');
			alert("change");
        });
});
</script>

<!--common script for all pages-->
<script src="resources/assets1/js/common-scripts.js"></script>
</html>