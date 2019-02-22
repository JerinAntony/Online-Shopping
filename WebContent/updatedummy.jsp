<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>