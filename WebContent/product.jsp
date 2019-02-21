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
	text-align: center;
	padding-left: 230px;
}

form {
	display: inline-block;
}
</style>
<body>
	<table align="center">
		<tr>
			<td></td>
			<td><h3>Add product</h3></td>
			<td></td>
		</tr>
	</table>

	<table>
		<tr>
			<td><form>
					<table>
						<tr>
							<td>Category</td>
							<td><select name="category">
									<c:forEach var="category" items="${CATEGORY}">
										<option value="${category.id }">${category.name }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>Product :</td>
							<td><input type="Text" name="product" ></td>
						</tr>
						<tr>
							<td>Description :</td>
							<td><input type="Text" name="description" ></td>
						</tr>
						<tr>
							<td>Quantity :</td>
							<td><input type="Text" name="quantity" ></td>
						</tr>
						<tr>
							<td>Price :</td>
							<td><input type="Text" name="price" ></td>
						</tr>
						<tr>
							<td>Expiration Date :</td>
							<td><input type="Text" name="expiration_date" required></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit">add product</button></td>
						</tr>
					</table>
				</form></td>
			<td style="width: 100px"></td>
			<td><form>
					<table>
						<tr>
							<td>Category :</td>
							<td><input type="Text" name="category" required></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit">Add category</button></td>
						</tr>

					</table>
				</form></td>
		</tr>
	</table>


</body>
</html>