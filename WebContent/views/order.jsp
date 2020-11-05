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
	<nav class="navbar navbar-dark bg-primary mb-2">
		<a class="navbar-brand" href="#"> Let's Order </a>
	</nav>

	<div class="container-fluid mb-2">
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">Sandwich</th>
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
				<div class="card">
					<div class="card-header">Order Bucket</div>
					<div class="card-body">
						<c:forEach items="${bucketList}" var="item">
						 	${item.itemName}
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="./src/bootstrap-input-spinner.js"></script>
<script>
	$("input[type='number']").inputSpinner()
</script>
</html>