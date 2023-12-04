<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="/img/logo.png" type="image/x-icon" />
<title>Forgot Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">

body {
	background-color: orange;
	color: white;
}
</style>

</head>
<body>
	<div class="container ">

		<div class="display-1 d-flex justify-content-center">ForgotPassword</div>

		<div class="card mt-5 mx-auto" style="max-width: 900px;">

			<form:form action="${route}" method="post" modelAttribute="admin">

				<div class="row g-0">

					<div class="col-md-6">
						<img src="/img/office.png" class="img-fluid rounded-start"
							alt="Office Image">
					</div>
					<div class="col-md-6 ">
						
						<div class="card-body text-primary mt-5">

							<div class="text-danger d-flex justify-content-center">${error}</div>
							<div class="text-success d-flex justify-content-center">${success}</div>
							<div class="form-floating mt-5 mb-3">
								<form:input path ="username" type="email" class="form-control" id="floatingInput"
									placeholder="name@example.com"  /> <label
									for="floatingInput">Email address</label>
							</div>
							<div class="input-group form-floating">
								<form:input path="password" type="password" class="form-control"
									id="floatingPassword"  placeholder="Password" />
									<label for="floatingPassword">New Password</label>
									<i	onclick="floatingPassword.type = (floatingPassword.type == 'text')? floatingPassword.type = 'password' : floatingPassword.type = 'text'  "							
									class="fa fa-eye input-group-text d-flex align-item-center "
									aria-hidden="true"></i>
				
							</div>
							<button class="btn btn-primary d-grid mx-auto mt-3" type="submit">Update Password</button>
							<div class = "d-flex justify-content-center mt-5 ">
								<a class= "text-decoration-none" href = "/">go to login page</a>
							</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>