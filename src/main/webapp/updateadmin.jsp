<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="/img/logo.png" type="image/x-icon" />
<title>Update Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
			body {
					background-color: orange
}
	</style>
</head>
<body>

	<div class="container ">

		<div class="display-1 d-flex justify-content-center">${TitleName}</div>


		<div class="card mt-3 mx-auto" style="max-width: 900px;">

			<form:form action="${route}" method="post" modelAttribute="admin">

				<div class="row g-0">

					<div class="col-md-6">
						<img src="/img/office.png" class="img-fluid rounded-start"
						style="height: 100%;width: 100%;"
							alt="Office Image">
					</div>
					<div class="col-md-6 ">

						<div class="card-body text-primary ">

							<div class="text-danger d-flex justify-content-center">${error}</div>
							<div class="text-success d-flex justify-content-center">${success}</div>
								<div class="form-floating   mb-3">
								<form:input path="name" type="text" class="form-control" value = "${oneAdmin.name}"
									id="floatingInput" placeholder="name@example.com" />
								<label for="floatingInput">Name</label>
							</div>

							<div class="form-floating mt-1 mb-3">
								<form:input path="username" type="email" class="form-control" value = "${oneAdmin.username}"
									id="floatingInput" placeholder="name@example.com" />
								<label for="floatingInput">Email Address</label>
							</div>
							<div class="input-group form-floating mt-1">
								<form:input path="password" type="password" class="form-control" value = "${oneAdmin.password}"
									id="floatingPassword" placeholder="Password" />
								<label for="floatingPassword">Password</label> <i
									onclick="floatingPassword.type = (floatingPassword.type == 'text')? floatingPassword.type = 'password' : floatingPassword.type = 'text'  "
									class="fa fa-eye input-group-text d-flex align-item-center "
									aria-hidden="true"></i>
							</div>													
							<button class="btn btn-primary d-grid mx-auto mt-3" type="submit">${btn}</button>

						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div></body>
</html>