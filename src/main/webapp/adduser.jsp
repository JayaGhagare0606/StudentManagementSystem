<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="/img/logo.png" type="image/x-icon" />
<title>Add User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<style type="text/css">
body {
	background-color: orange;
}
</style>

</head>
<body>
	<div class="container">
		<div class="display-1 d-flex justify-content-center">${TitleName}</div>

		<div class="card mt-3 mx-auto" style="max-width: 900px;">

			<form:form action="${route}" method="post" modelAttribute="admin">

				<div class="row g-0">

					<div class="col-md-6">
						<img src="/img/office.png" class="img-fluid rounded-start"
							alt="Office Image">
					</div>
					<div class="col-md-6 ">

						<div class="card-body text-primary ">

							<div class="text-danger d-flex justify-content-center">${error}</div>
							<div class="text-success d-flex justify-content-center">${success}</div>
							<div class="form-floating   mb-3">
								<form:input path="name" type="text" class="form-control"
									id="floatingInput" placeholder="name@example.com" />
								<label for="floatingInput">Name</label>
							</div>

							<div class="form-floating mt-1 mb-3">
								<form:input path="username" type="email" class="form-control"
									id="floatingInput" placeholder="name@example.com" />
								<label for="floatingInput">Email Address</label>
							</div>
							<div class="input-group form-floating mt-1">
								<form:input path="password" type="password" class="form-control"
									id="floatingPassword" placeholder="Password" />
								<label for="floatingPassword">Password</label> <i
									onclick="floatingPassword.type = (floatingPassword.type == 'text')? floatingPassword.type = 'password' : floatingPassword.type = 'text'  "
									class="fa fa-eye input-group-text d-flex align-item-center "
									aria-hidden="true"></i>
							</div>
							<div class="form-floating mt-3">
								<form:select path="role" class="form-select" id="floatingSelect"
									aria-label="Select Your Role">
									<option selected value="select">Select</option>
									<option value="User">User</option>
									<option value="Manager">Manager</option>
									<option value="Admin">Admin</option>
								</form:select> <label for="floatingSelect">Select Your Role</label>
							</div>
							<button class = "btn btn-primary d-grid mx-auto mt-3" type="submit">${btn}</button>
							<a href="/admin">go to admin</a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>