<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		<form method="post" action="DeleteProductServlet">
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

	<table>
		<tr align="center">
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="UpdateProductServlet">

						<h2 style="color: white;">Update Product</h2>
						<table>
							<tr>
								<td style="color: white;">Product :</td>
								<td><select name="product">
										<c:forEach var="product" items="${PRODUCT}">
											<option value="${product.id}">${product.product}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Price :</td>
								<td><input type="number" name="price"></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td style="color: white;">Quantity :</td>
								<td><input type="number" name="quantity"></td>
							</tr>
							<tr>
								<td></td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Update</button>
								</td>
							</tr>
						</table>

					</form>






				</div>
			</td>
			<td>
				<div align="center" style="width: 600px">

					<form method="post" action="DeleteProductServlet">

						<h2 style="color: white;">Delete</h2>
						<table>
							<tr>
								<td style="color: white;">Product Id :</td>
								<td><input type="number" name="productId"></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Delete</button>
								</td>
							</tr>
						</table>

					</form>




				</div>
			</td>
		</tr>
	</table>
</body>
</html>