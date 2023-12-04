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

		<div class="display-1 d-flex justify-content-center">Forgot Password</div>

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
							<div class="form-floating mt-5 mb-3">
								<form:input path ="username" type="email" class="form-control" id="floatingInput"
									placeholder="name@example.com" /> <label
									for="floatingInput">Email address</label>
							</div>
						
							<button class="btn btn-primary d-grid mx-auto mt-3" type="submit">Validate</button>
							
							<div class=" d-flex justify-content-center mt-3">
								<p>
									<a href="/" class="mx-2 text-decoration-none text-success">go
										to login page</a>
								</p>
							</div>
							
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>