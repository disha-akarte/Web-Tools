<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CandidateSignUp</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="resources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/assets/css/form-elements.css">
<link rel="stylesheet" href="resources/assets/css/style.css">

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="resources/assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/assets/ico/apple-touch-icon-57-precomposed.png">

<style>
.bgimage {
	background-image: url('resources/assets/img/backgrounds/1.jpg');
	background-position: center center;
	background-size: cover;
	height: 1400px;
}

.abc {
	color: black;
}
</style>

</head>
<body class="bgimage">
	<div class="top-content">


		<div class="container">

			<div class="row">
				<div class="col-sm-10 col-sm-offset-2 text abc">
					<h1>
						<strong>Candidate Registration</strong>
					</h1>
					
			</div>


			<div class="row">
				<div class="col-sm-8">

					<div class="form-box">
						<div class="form-top">
							<div class="form-top-left abc">
								<h3>Sign up now</h3>
								<p>Fill in the form below to get instant access:</p>
							</div>
							
						</div>
						<div class="form-bottom">

							<form:form role="form" action="addcandidate.htm"
								class="registration-form" commandName="candidate" method="post"
								enctype="multipart/form-data">
								<div class="form-group">
									<label class="sr-only" for="form-email">Email ID</label>
									<form:input path="emailId" size="30" name="form-email"
										placeholder="Email Address"
										class="form-first-name form-control" id="form-first-name" />
									<font color="red"><form:errors path="emailId" /></font>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label>
									<form:password path="password" size="30" name="form-password"
										placeholder="Password" class="form-last-name form-control"
										id="form-last-name" />
									<font color="red"><form:errors path="password" /></font>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-confirm-password">Confirm
										Password</label>
									<form:password path="confirmPassword" size="30"
										name="form-confirm-password" placeholder="Confirm Password"
										class="form-email form-control" id="form-email" />
									<font color="red"><form:errors path="confirmPassword" /></font>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-first-name">First Name</label>
									<form:input path="first" size="30" name="form-company-name"
										placeholder="First Name" class="form-email form-control"
										id="form-first-name" />
									<font color="red"><form:errors path="first" /></font>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-last-name">Last Name</label>
									<form:input path="last" size="30" name="form-location"
										placeholder="Last Name" class="form-location form-control"
										id="form-last-name" />
									<font color="red"><form:errors path="last" /></font>
								</div>

								<div class="form-group">
									<label class="sr-only" for="form-last-name">Phone</label>
									<form:input path="phone" size="30" name="form-location"
										placeholder="Phone" class="form-location form-control"
										id="form-last-name" />
									<font color="red"><form:errors path="phone" /></font>
								</div>

								<div class="form-group">
									<label class="sr-only" for="form-last-name">Address</label>
									<form:input path="address" size="30" name="form-location"
										placeholder="Location" class="form-location form-control"
										id="form-last-name" />
									<font color="red"><form:errors path="address" /></font>
								</div>
								
								<div class="form-group">
									<input name="fileUpload" type="file" />
								</div>

								<button type="submit" class="btn">Sign me up!</button>
							</form:form>
						</div>

					</div>

				</div>
			</div>
		</div>
</div>
</div>
	
	<footer>
			<p>Copyright</p>
	</footer>


	<!-- Javascript -->
	<script src="resources/assets/js/jquery-1.11.1.min.js"></script>
	<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/jquery.backstretch.min.js"></script>
	<script src="resources/assets/js/scripts.js"></script>


</body>

</html>