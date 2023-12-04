<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="/img/logo.png" type="image/x-icon" />
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
		<style type="text/css">
				body{
					background-color: orange;
				}
				
		</style>
</head>
<body>
		<div>
			
					<nav class="navbar navbar-expand-lg  navbar-dark bg-dark " style="border-bottom: 3px dashed #fff8;">
				  <div class="container-fluid ">
				    <a class="navbar-brand text-light" href="#"><img alt="JSRASLogo" src="/img/logo.png" style="width: 70px; height: 70px;">JSRAS</a>
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse " id="navbarText">
				      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				        <li class="nav-item ">
				          <a class="nav-link active text-light" aria-current="page" href="/home">Home</a>
				        </li>
				      
				        <li class="nav-item">
				          <a class="nav-link text-light" href="/admin">${role == 'Admin' ? 'Admin' : ''}</a>
				        </li>
				      
				        <li class="nav-item">
				          <a class="nav-link text-light" href="/">Logout</a>
				        </li>
				        <li class="nav-item d-flex align-item-center" >
				        	<span class="nav-link text-success" style="font-size: 20px;">Welcome 
				        		<span class="mx-2 text-white"> ${user}</span>
				        	</span>
				        	
				        </li>
				      </ul>
				      
				    </div>
				  </div>
				</nav>
		</div>
		<div class="mt-5">
		<div class="display-6 d-flex justify-content-center text-white">STUDENT LIST</div>
		<div class="d-grid  justify-content-end mx-5">
		<a href="/addstudent">
			<button class ="btn btn-primary ">Add Student</button>
		</a>
		</div>
		
		<hr class = "text-white">
				<table class="table text-white center">
					<thead>
					
						<tr>
							<th>SrNo</th>
							<th>Student Name</th>
							<th>Age</th>
							<th>Address</th>
							<th>DOB</th>
							<th>Phone</th>
							<th>Roll Number</th>
							<th>Action</th>
						</tr>
					
					</thead>
					<tbody>
						
							<c:forEach var="std" items="${studentList}" varStatus="loop" >
							<tr>
									<td>${loop.index+1}</td>
									<td>${std.name}</td>
									<td>${std.age}</td>
									<td>${std.address}</td>
									<td>${std.dob}</td>
									<td>${std.phone}</td>
									<td>${std.rollnumber}</td>
									<td>
										<a href="/update/${std.id}"><button
										class="btn btn-primary text-white">Edit</button></a> <a
								href="/delete/${std.id}"><button class="btn btn-danger text-white">Delete</button></a>
							</td>
							</tr>		
							</c:forEach>
					</tbody>
				</table>
		</div>
</body>
</html>