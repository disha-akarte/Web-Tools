<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>HomePage</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/nivo-lightbox.css" rel="stylesheet" />
<link href="resources/css/nivo-lightbox-theme/default/default.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/owl.carousel.css" rel="stylesheet"
	media="screen" />
<link href="resources/css/owl.theme.css" rel="stylesheet" media="screen" />
<link href="resources/css/flexslider.css" rel="stylesheet" />
<link href="resources/css/animate.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/color/default.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

</head>

<style>
.bgimage {
	background-image:
		url('resources/img/Fotolia_52179055_Subscription_XXL.jpg');
	background-position: center center;
	background-size: cover;
	height: 1400px;
}
</style>

<body class="bgimage">

	<div id="navigation">
		<nav class="navbar navbar-custom" role="navigation">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="site-logo">
							<p style="font-size: 45px;" class="brand">JobPortal</p>
						</div>
					</div>
					<div class="col-md-7  search">
					
						<form class="navbar-form " role="search">

							
						</form>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="menu">

						<button class="btn btn-default" type="submit" data-toggle="modal"
							data-target="#myModal" id="myButton">
							Login<i class="glyphicon glyphicon-user"></i>
						</button>
						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>

										<h2 class="form-signin-heading">Please Sign In</h2>
									</div>
									<div class="modal-body">
										<form action="login.htm" class="form-signin" method="Post">
											<label for="inputEmail" class="sr-only">Email address</label>
											<input type="email" name="emailId" class="form-control" placeholder="Email address" required autofocus> 
											<label for="inputPassword" class="sr-only">Password</label>
												<input type="password" name="password" class="form-control" placeholder="Password" required>
											<c:if test="${!empty requestScope.invalidDetails}">
												<p style="color: red">Invalid credentials</p>
											</c:if> 
											<div class="checkbox">
												<label> <input type="checkbox" name="rem" value="remember-me">Remember me</label>
												
											</div>
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="Login"/>
											<input type="hidden" name="action" value="login">											
										</form>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
	</nav>
	</div>

	<div class="selection">
		<div class="row">
			<div class="row btnn">
				<div id='cand' class="col-sm-6">

					<!--<button  type="submit" style="font-size:24px" class="btn btn-success">Search <i class="fa fa-suitcase"></i></button>-->
					<a href="addcandidate.htm"><img 
						src="resources/img/searching.jpg" class="img-circle cand"
						alt="Candidate" width="275" height="275"></a>
				</div>
				<div id='emp' class="col-sm-6">

					<!--<button  type="submit" style="font-size:24px" class="btn btn-success">Post <i class="fa fa-envelope-o"></i></button>-->
					<a href="addcompany.htm"><img src="resources/img/job-company.png" class="img-circle emp"
						alt="Employer" width="275" height="275"></a>
				</div>
			</div>

			
				<hr>
				<footer style="margin-top: 90%;"><p>&copy; 2016 Job Portal.</p></footer>
			
	
			<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>	
				
<script>
var invalidDetails = '${invalidDetails}';
$(document).ready(function() {
		$('.cand').mouseover(function() {
			$(this).attr("src", "resources/img/searching_hover.jpg");
		}).mouseout(function() {
			$(this).attr("src", "resources/img/searching.jpg");
		});	
	
	$('.emp').mouseover(function() {
		$(this).attr("src", "resources/img/job-company_hover.png");
	}).mouseout(function() {
		$(this).attr("src", "resources/img/job-company.png");
	});
	
	$('#myButton').click(function(){
		$("#myModal").modal();
	});
	if(invalidDetails === 'true'){
		$('#myModal').modal("show");
	}
});

</script>				
</body>
</html>
