<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="/img/logo.png" type="image/x-icon" />
<title>Add Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
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

			<form:form action="${route}" method="post" modelAttribute="student">

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
							<div class="form-floating  mt-5 mb-3">
								<form:input path="name" type="text" class="form-control"
									id="floatingInput" placeholder="name@example.com" />
								<label for="floatingInput">Name</label>
							</div>
							<div class="form-floating mt-3 mb-3">
								<form:input path="address" type="text" class="form-control"
									id="floatingInput" placeholder="Enter Your Address" />
								<label for="floatingInput">Address</label>
							</div>
							<div class="form-floating mt-3">
								<form:select path="city" class="form-select" id="floatingSelect"
									aria-label="City">
									<option selected value="">Select</option>
									<c:forEach  items="${city}" var="city">
										
										<option 
										${cityValue eq city.name ? 'selected' : ''}
											value="${city.cid}"
											
										>
													${city.name}
										</option>
									</c:forEach>
									</form:select> <label for="floatingSelect">City</label>
							
							</div>

							<div class="form-floating mt-3 mb-3">
								<form:input path="age" type="text" class="form-control"
									id="floatingInput" placeholder="Enter your Age" />
								<label for="floatingInput">Age</label>
							</div>
							
							<div class="form-floating mt-3 mb-3">
								<form:input path="dob" type="date" class="form-control"
									id="floatingInput" placeholder="Enter Date of Birth" />
								<label for="floatingInput">Enter Date Of Birth</label>
							</div>
							
							<div class="form-floating mt-3 mb-3">
								<form:input path="rollnumber" type="text" class="form-control"
									id="floatingInput" placeholder="Enter Roll Number" />
								<label for="floatingInput">Enter Roll Number</label>
							</div>
							
							<div class="form-floating mt-3 mb-3">
								<form:input path="phone" type="text" class="form-control"
									id="floatingInput" placeholder="Enter Phone Number" />
								<label for="floatingInput">Enter Phone Number</label>
							</div>
							
							<div class="form-floating mt-3">
								<form:select path="status" class="form-select" id="floatingSelect"
									aria-label="Select Status Of Student">
									<option value="1" selected="selected">Active</option>
									<option value="0">InActive</option>
									
								</form:select> <label for="floatingSelect">Select Status Of Student</label>
							</div>
							
							
							
							<button class="btn btn-primary d-grid mx-auto mt-3" type="submit" ${disabled}>${btn}</button>

							<a href="/home" class="text-decoration-none d-flex justify-content-center mt-3">go to home</a>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
		
</body>
</html>

<!--  Complete Add student as well as update student form  -->