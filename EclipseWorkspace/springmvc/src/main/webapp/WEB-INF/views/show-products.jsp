<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of products</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1 class="alert alert-danger">List of products</h1>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Unit Price</th>
					<th>Quantity Per Unit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p">
					<tr>
						<td>${p.productName}</td>
						<td>${p.category.categoryName}</td>
						<td>${p.supplier.companyName}</td>
						<td>${p.unitPrice}</td>
						<td>${p.quantityPerUnit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>





