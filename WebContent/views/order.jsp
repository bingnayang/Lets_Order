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
<body class="bg-light">
	<!-- Image and text -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#"> Let's Order </a>
	</nav>
	<nav class="navbar navbar-light mb-2"
		style="background-color: #e3f2fd;">
		<div class="form-inline">
			<button type="button" class="btn btn-outline-primary mr-sm-2">Order
				Menu</button>
			<a type="button" class="btn btn-outline-primary"
				href="${pageContext.request.contextPath}/OrderController?action=VIEW_ACTIVE">All
				Active Orders</a>
		</div>
	</nav>

	<div class="container-fluid mb-2">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">Menu Item</th>
									<th scope="col">Price</th>
									<th scope="col">Add</th>
								</tr>
							</thead>
							<c:forEach items="${allMenuList}" var="item">
								<tr>
									<td>${item.itemName}</td>
									<td>$ ${item.itemPrice}</td>
									<td><button type="button" class="btn btn-primary btn-sm"
											onclick="window.location.href='${pageContext.request.contextPath}/MenuController?action=SELECT&id=${item.item_Id}'">+</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="col">
				<form action="${pageContext.request.contextPath}/OrderController?action=SUBMIT"
					method="POST">
					<div class="card">
						<div class="card-header">Order Bucket</div>
						<div class="card-body">
							<table class="table">
								<thead class="thead-light">
									<tr>
										<th scope="col">Item</th>
										<th scope="col">Price</th>
										<th scope="col">DELETE</th>
									</tr>
								</thead>
								<c:forEach items="${bucketList}" var="item">
									<tr>
										<td><div class="form-group"><input class="form-control" name="item_Name" value="${item.itemName}" readonly></div></td>
										<td><input class="form-control" name="item_Price" value="${item.itemPrice}" readonly></td>
										<td><button type="button" class="btn btn-danger btn-sm"
												onclick="window.location.href='${pageContext.request.contextPath}/MenuController?action=DELETE&id=${item.item_Id}'">X</button></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="card-footer text-muted">
							<ul class="list-group list-group-flush">
								<li class="list-group-item"># Item: <input name="item_Quantity" value="${itemCount}" readonly></li>
								<li class="list-group-item">Total: $<input name="order_Total" value="${orderTotal}" readonly></li>
								<li class="list-group-item">
									<button type="submit" class="btn btn-primary btn-block">Submit Order</button>
								</li>
								<li class="list-group-item"><button type="button"
										class="btn btn-danger btn-block"
										onclick="window.location.href='${pageContext.request.contextPath}/MenuController?action=DELETE_ALL'">Clear
										All</button></li>
							</ul>
						</div>
					</div>
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