<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<style>
body {
	background: url("wallpaper.png");
	text-align: center;
	padding-top: 50px;
}

form {
	display: inline-block;
}
</style>
<body>
	<div align="center">
		<form method="post">
			<h3 style="color: white">Products list</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse; color: white">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Category</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Product</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Price</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Quantity</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Expired
							date</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Status</th>
						<!-- <th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;"><button
								type="submit">Delete</button></th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${PRODUCT}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${product.categoryId.name}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${product.product}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${product.price}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${product.quantity}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${product.expiredDate}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${product.status}</td>
							<%-- <td><input type="checkbox" name="delete"
								value="${product.id}"></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>