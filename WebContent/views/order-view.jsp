<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<body class="bg-light">
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
				onclick="window.location.href='${pageContext.request.contextPath}/OrderController?action=VIEW_ACTIVE'">Active
				Order List</button>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="d-flex flex-wrap">
			<c:forEach items="${allOrderList}" var="order">
				<div class="card bg-light"
					style="width: 18rem; margin-right: 15px; margin-bottom: 15px; border: none;">
					<div class="card-header bg-secondary text-light">
						<div class="row">
							<div class="col-auto mr-auto">Order # ${order.ticket_Id}</div>
							<div class="col-auto">
								<button type="button" 
									class=""
									onclick="window.location.href='${pageContext.request.contextPath}/OrderController?action=DELETE&id=${order.ticket_Id}'"
									style="border: none; background-color: #6c757d; color:white;"><i class='far fa-trash-alt'></i></button>
							</div>
						</div>
					</div>
					<c:forEach items="${allOrderItemList}" var="item">
						<c:if test="${order.ticket_Id == item.ticket_Id}">
							<ul class="list-group list-group-flush"
								style="border-style: solid;border-color: #6c757d;">
								<li class="list-group-item">
									<div class="row">
										<div class="col-auto mr-auto">- ${item.name}</div>
										<div class="col-auto">$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.price}"/></div>
									</div>
								</li>
							</ul>
						</c:if>
					</c:forEach>

					<div class="card-footer bg-secondary text-light">Quantity:
						${order.orderQuantity}</div>
					<div class="card-footer bg-secondary text-light">Total: $
						<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${order.orderTotal}"/></div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
		
</body>
</html>