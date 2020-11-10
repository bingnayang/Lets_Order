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
<title>Active Order List</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#"> Let's Order </a>
	</nav>
	<nav class="navbar navbar-light mb-2"
		style="background-color: #e3f2fd;">
		<div class="form-inline">
			<button type="button" class="btn btn-outline-primary mr-sm-2"
				onclick="window.location.href='${pageContext.request.contextPath}/MenuController?action=LIST'">Order
				Menu</button>
			<button type="submit" class="btn btn-outline-primary"
				onclick="window.location.href='${pageContext.request.contextPath}/views/order-view.jsp'">Active
				Order List</button>
		</div>
	</nav>

	<div class="d-flex flex-row">
		<c:forEach items="${allOrderList}" var="item">
			<div class="p-2">
				<div class="card" style="width: 18rem;">
					<div class="card-header">Order # ${item.order_Id} | Quantity
						# ${item.orderQuantity}</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">${item.itemName}</li>
					</ul>
					<div class="card-footer">Total $ ${item.orderTotal}</div>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>