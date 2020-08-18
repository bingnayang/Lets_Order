<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Let's Order Web App</title>
</head>
<body>
	<!-- Image and text -->
	<nav class="navbar navbar-dark bg-dark mb-2">
		<a class="navbar-brand" href="#">
			Let's Order
		</a>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="bg-dark text-center text-light"><h4>Menu</h4></div>
				<div class="list-group">
					<c:forEach items="${allMenuList}" var="item">
						<div
							class="list-group-item list-group-item-action flex-column align-items-start">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1">${item.itemName}</h5>
								<input type="number" value="0" min="0" max="5" step="1" />
							</div>
							<p class="mb-1">${item.description}</p>
							<p class="mb-1">$ ${item.itemPrice}</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col">
				<div class="bg-dark text-center text-light">
					<h4>Order</h4>
				</div>
				<form action="">
					<label>Order Items List</label>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="./src/bootstrap-input-spinner.js"></script>
<script>
	$("input[type='number']").inputSpinner()
</script>
</html>