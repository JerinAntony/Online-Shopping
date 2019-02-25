<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order</title>
</head>
<style>
body {
	background: url("wallpaper.png");
	text-align: center;
	padding-top: 230px;
}

form {
	display: inline-block;
}
</style>
<body
	style="color: white; font-family: Times New Roman; font-size: 19px">
	<form method="post" action="PlaceOrderServlet">
		<table>
			<tbody>
				<tr align="center">
					<td style="color: white" colspan="2" style="padding-top:50px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Place
						Order</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>


				<tr>


					<td style="color: white">Product Id :</td>
					<td><select name="product">
							<c:forEach var="product" items="${PRODUCT}">
								<option value="${product.id}">${product.product}</option>
							</c:forEach>
					</select></td>

				</tr>
				<tr>
					<td></td>
				</tr>

				<tr align="left">
					<td style="color: white">Quantity :</td>
					<td><input type="number" name="quantity"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button style="width: 100px;" type="submit">Buy</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

	
</body>
</html>